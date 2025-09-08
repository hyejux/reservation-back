package com.reservation.reservation_server.controller.user;

import com.reservation.reservation_server.config.Security.CustomUserDetails;
import com.reservation.reservation_server.config.Security.CustomUserDetailsService;
import com.reservation.reservation_server.dto.CustomUserInfoDto;
import com.reservation.reservation_server.dto.UserResponseDto;
import com.reservation.reservation_server.entity.User;
import com.reservation.reservation_server.service.user.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAccountController {


    private final UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }


    /**
     * 내 정보 조회 기능
     */
    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> getUserInfo(@AuthenticationPrincipal CustomUserDetails customUserDetails){
        UserResponseDto userInfo = userAccountService.getUserInfo(customUserDetails.getId());
        return ResponseEntity.status(HttpStatus.OK).body(userInfo);
    }

    /**
     * 내 정보 수정 기능
     */
    @PostMapping("/")
    public void updateUserInfo(){

    }


}
