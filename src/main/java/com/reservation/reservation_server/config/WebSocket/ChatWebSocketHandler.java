package com.reservation.reservation_server.config.WebSocket;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reservation.reservation_server.config.Security.JwtUtil;
import com.reservation.reservation_server.entity.ChatMessage;
import com.reservation.reservation_server.entity.ChatRoom;
import com.reservation.reservation_server.repository.ChatMessageRepository;
import com.reservation.reservation_server.repository.ChatRoomRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {


    private final ObjectMapper mapper = new ObjectMapper();
    private final JwtUtil jwtUtil;
    // 현재 연결된 세션 저장
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    public ChatWebSocketHandler(JwtUtil jwtUtil, ChatRoomRepository chatRoomRepository, ChatMessageRepository chatMessageRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.jwtUtil = jwtUtil;
        this.chatMessageRepository = chatMessageRepository;
    }


    // 클라이언트가 연결될 때
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Authorization 헤더 가져오기
        String token = session.getHandshakeHeaders().getFirst("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            session.close(CloseStatus.NOT_ACCEPTABLE.withReason("JWT 없거나 잘못됨"));
            return;
        }

        // "Bearer " 제거 후 검증
        token = token.substring(7);
        if (!jwtUtil.isValidToken(token)) {
            session.close(CloseStatus.NOT_ACCEPTABLE.withReason("유효하지 않은 JWT"));
            return;
        }

        // JWT에서 userId 추출
        Long userId = jwtUtil.getUserId(token);
        String userIdStr = String.valueOf(userId); // Map key용 String

        // 세션 등록
        sessions.put(userIdStr, session);
        System.out.println("Connected: userId=" + userIdStr);
    }

    // 클라이언트가 메시지를 보낼 때
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        JsonNode json = mapper.readTree(message.getPayload());
        String toId = json.get("to").asText();
        String content = json.get("content").asText();

        String fromId = sessions.entrySet().stream()
                .filter(entry -> entry.getValue().equals(session))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        if (fromId == null) return;

        // ChatRoom 조회 또는 생성
        ChatRoom chatRoom = chatRoomRepository.findByUserIdAndStoreId(
                Long.valueOf(fromId), Long.valueOf(toId)
        ).orElseGet(() -> {
            ChatRoom room = new ChatRoom();
            room.setUserId(Long.valueOf(fromId));
            room.setStoreId(Long.valueOf(toId));
            return chatRoomRepository.save(room);
        });

        // 메시지 DB 저장
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChatRoom(chatRoom);
        chatMessage.setSenderId(Long.valueOf(fromId));
        chatMessage.setContent(content);
        chatMessageRepository.save(chatMessage);

        // WebSocket 전송 (상대방이 온라인이면)
        WebSocketSession receiverSession = sessions.get(toId);
        if (receiverSession != null && receiverSession.isOpen()) {
            ObjectNode response = mapper.createObjectNode();
            response.put("from", fromId);
            response.put("content", content);
            receiverSession.sendMessage(new TextMessage(response.toString()));
        }
    }

    // 클라이언트 연결 종료
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        sessions.remove(session);
//        System.out.println("Disconnected: " + session.getId());
        String userId = session.getId();
        sessions.remove(userId);
    }

    // 오류 발생 시
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("Error: " + exception.getMessage());
        session.close(CloseStatus.SERVER_ERROR);
    }
}
