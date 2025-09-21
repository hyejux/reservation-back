package com.reservation.reservation_server.dto;

import com.reservation.reservation_server.common.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationFormDto {

//    private Long reservationId;
    private LocalDate date;
    private LocalTime time;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
    private ReservationStatus isActive;
    private Long userId;
    private Long productId;
    private Long storeId;

}
