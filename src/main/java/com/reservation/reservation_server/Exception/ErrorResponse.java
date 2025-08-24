package com.reservation.reservation_server.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse { // 공통 메서드로 추상화할 인터페이스 정의
    private String code;
    private String message;

}
