package com.reservation.reservation_server.serviceImpl.user;

import com.reservation.reservation_server.dto.StoreResponseDto;
import com.reservation.reservation_server.entity.Store;
import com.reservation.reservation_server.repository.StoreRepository;
import com.reservation.reservation_server.service.store.StoreAccountServcie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreAccountServiceImpl implements StoreAccountServcie {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreAccountServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


    @Override
    public StoreResponseDto getStoreInfo(Long storeId) {
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        StoreResponseDto dto = StoreResponseDto.builder()
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
                .isActive(Boolean.TRUE.equals(store.getIsActive())) // null 안전 처리
                .role(store.getRole())
                .build();

        return dto;
    }

}
