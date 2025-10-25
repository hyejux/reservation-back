package com.reservation.reservation_server.controller.chat;


import com.reservation.reservation_server.config.Security.JwtUtil;
import com.reservation.reservation_server.dto.ChatMessageDto;
import com.reservation.reservation_server.dto.ChatRoomDto;
import com.reservation.reservation_server.entity.ChatMessage;
import com.reservation.reservation_server.entity.ChatRoom;
import com.reservation.reservation_server.repository.ChatMessageRepository;
import com.reservation.reservation_server.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final JwtUtil jwtUtil;

    // 1. 채팅 목록 조회 (스토어 입장에서)
    @GetMapping("/rooms")
    public List<ChatRoomDto> getChatRooms(@RequestHeader("Authorization") String token) {
        Long storeId = jwtUtil.getUserId(token.substring(7));
        List<ChatRoom> rooms = chatRoomRepository.findAllByStoreId(storeId);

        // DTO로 변환, 마지막 메시지, 안 읽은 메시지 수 포함
        return rooms.stream().map(room -> {
            ChatMessage lastMessage = chatMessageRepository.findTopByChatRoomIdOrderByCreatedAtDesc(room.getId());
            long unreadCount = chatMessageRepository.countByChatRoomIdAndReadStatusFalse(room.getId());
            return new ChatRoomDto(room.getId(), room.getUserId(), lastMessage.getContent(), unreadCount);
        }).collect(Collectors.toList());
    }

    @GetMapping("/rooms/{roomId}/messages")
    public List<ChatMessageDto> getMessages(@PathVariable Long roomId) {
        return chatMessageRepository.findAllByChatRoomIdOrderByCreatedAtAsc(roomId)
                .stream()
                .map(msg -> new ChatMessageDto(
                        msg.getSenderId(),
                        msg.getContent(),
                        msg.getCreatedAt(),
                        msg.getReadStatus()   // 읽음 상태 포함
                ))
                .collect(Collectors.toList());
    }

}
