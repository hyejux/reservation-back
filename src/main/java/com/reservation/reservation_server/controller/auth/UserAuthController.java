package com.reservation.reservation_server.controller.auth;

import com.reservation.reservation_server.dto.LoginRequestDto;
import com.reservation.reservation_server.dto.UserSignupRequestDto;
import com.reservation.reservation_server.entity.User;
import com.reservation.reservation_server.service.auth.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/user")
public class UserAuthController {

    private final UserAuthService userAuthService;

    @Autowired
    public UserAuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    /**
     * 사용자 회원가입
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserSignupRequestDto request) {
        try{
            User user = userAuthService.signup(request);
            return ResponseEntity.ok("회원가입 성공 : " + user.getEmail());
        }catch(IllegalArgumentException e){
            System.out.println("회원가입 실패");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("회원가입 실패");
        }
    }

    /**
     * 사용자 로그인 (JWT 토큰 발급)
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto request) {

        String token =  userAuthService.login(request);

        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    /**
     * 사용자 로그아웃
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/logout")
    public String logout(@RequestParam String username, @RequestParam String password) {
        return "test";
    }

}
