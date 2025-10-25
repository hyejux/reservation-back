package com.reservation.reservation_server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_room")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1:1 채팅 기준 유저
    @Column(name = "user_id", nullable = false)
    private Long userId;

    // 1:1 채팅 기준 스토어
    @Column(name = "store_id", nullable = false)
    private Long storeId;

    // 채팅 메시지 연관
    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatMessage> messages;

    // 필요시 채팅방 이름/타이틀 등 추가 가능
    // @Column(name = "title")
    // private String title;
}
