package com.reservation.reservation_server.serviceImpl.user;

import com.reservation.reservation_server.config.Security.CustomUserDetails;
import com.reservation.reservation_server.dto.CustomUserInfoDto;
import com.reservation.reservation_server.dto.UserResponseDto;
import com.reservation.reservation_server.entity.User;
import com.reservation.reservation_server.repository.UserRepository;
import com.reservation.reservation_server.service.user.UserAccountService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserRepository userRepository;

    @Autowired
    public  UserAccountServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto getUserInfo(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        UserResponseDto dto = new UserResponseDto();
        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setRole(user.getRole());

        return dto;
    }

//    @Override
//    public User getUserInfo(Long userId) {
//        if (userId == null) {
//            throw new IllegalArgumentException("인증된 사용자 정보가 없습니다.");
//        }
//        return userRepository.findByUserId(userId.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
//    }

}
