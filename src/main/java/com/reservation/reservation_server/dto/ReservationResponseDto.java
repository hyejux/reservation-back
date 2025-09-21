package com.reservation.reservation_server.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Setter
@Getter
public class ReservationResponseDto {

    private Long reservationId;

    private LocalDate date;

    private LocalTime time;

    private String status; //  enum의 문자열 표현

    private Boolean isActive;

    private Long userId;

    private Long productId;

    private Long storeId;

    private String userName; // User 엔티티의 이름 등 필요한 정보 추가 가능

    private String productName; // Product 엔티티의 이름 등

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
