package com.reservation.reservation_server.dto;

import com.reservation.reservation_server.common.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class StoreResponseDto {

    private Long storeId;
    private String email;
    private String name;
    private String ownerName;
    private String phoneNumber;
    private String address;
    private String description;
    private String category;
    private String bizRegistrationNum;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive; // primitive boolean으로 안전하게 처리
    private RoleType role;

    // Store 엔티티 -> DTO 변환
    public static StoreResponseDto fromEntity(com.reservation.reservation_server.entity.Store store) {
        return StoreResponseDto.builder()
                .storeId(store.getStoreId())
                .email(store.getEmail())
                .name(store.getName())
                .ownerName(store.getOwnerName())
                .phoneNumber(store.getPhoneNumber())
                .address(store.getAddress())
                .description(store.getDescription())
                .category(store.getCategory())
                .bizRegistrationNum(store.getBizRegistrationNum())
                .createdAt(store.getCreatedAt())
                .updatedAt(store.getUpdatedAt())
                .isActive(Boolean.TRUE.equals(store.getIsActive())) // null 안전하게
                .role(store.getRole())
                .build();
    }
}