package com.reservation.reservation_server.service.auth;

import com.reservation.reservation_server.dto.LoginRequestDto;
import com.reservation.reservation_server.dto.StoreLoginResponseDto;
import com.reservation.reservation_server.dto.StoreSignupRequestDto;
import com.reservation.reservation_server.entity.Store;


public interface StoreAuthService {

    Store signup(StoreSignupRequestDto request);
    StoreLoginResponseDto login(LoginRequestDto request);

}
