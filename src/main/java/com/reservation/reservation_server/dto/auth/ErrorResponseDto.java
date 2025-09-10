package com.reservation.reservation_server.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {
    private int value;
    private String message;
    private LocalDateTime now;

}
