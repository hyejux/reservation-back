package com.reservation.reservation_server.service.auth;

import com.reservation.reservation_server.dto.LoginRequestDto;
import com.reservation.reservation_server.dto.UserSignupRequestDto;
import com.reservation.reservation_server.dto.auth.UserLoginResponseDto;
import com.reservation.reservation_server.entity.User;

public interface UserAuthService {
    User signup(UserSignupRequestDto request);
    UserLoginResponseDto login(LoginRequestDto request);
}
