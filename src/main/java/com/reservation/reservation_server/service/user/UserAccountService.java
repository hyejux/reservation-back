package com.reservation.reservation_server.service.user;

import com.reservation.reservation_server.dto.CustomUserInfoDto;
import com.reservation.reservation_server.dto.UserResponseDto;
import com.reservation.reservation_server.entity.User;

public interface UserAccountService {
    public UserResponseDto getUserInfo(Long userId) ;

}
