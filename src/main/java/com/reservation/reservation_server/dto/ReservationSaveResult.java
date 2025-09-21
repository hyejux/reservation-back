package com.reservation.reservation_server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
public class ReservationSaveResult {
    private boolean success;         // 성공 여부
    private String message;          // 실패 사유 메시지
    private ReservationResponseDto reservation; // 예약 저장 결과 (성공 시)
    // 생성자, getter/setter
}
