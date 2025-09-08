package com.reservation.reservation_server.service.auth;

import com.reservation.reservation_server.dto.LoginRequestDto;
import com.reservation.reservation_server.dto.SigupRequestDto;
import com.reservation.reservation_server.entity.User;

public interface UserAuthService {
    User signup(SigupRequestDto request);
    String login(LoginRequestDto request);
}
