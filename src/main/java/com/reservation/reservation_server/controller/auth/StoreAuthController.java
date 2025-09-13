package com.reservation.reservation_server.controller.auth;

import com.reservation.reservation_server.dto.LoginRequestDto;
import com.reservation.reservation_server.dto.StoreSignupRequestDto;
import com.reservation.reservation_server.entity.Store;
import com.reservation.reservation_server.entity.User;
import com.reservation.reservation_server.service.auth.StoreAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store/auth")
public class StoreAuthController {

    private final StoreAuthService storeAuthService;

    @Autowired
    public StoreAuthController(StoreAuthService storeAuthService) {
        this.storeAuthService = storeAuthService;
    }

    /**
     * 스토어 회원가입
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody StoreSignupRequestDto request) {
        try{
            Store store = storeAuthService.signup(request);
            return ResponseEntity.ok("회원가입 성공 : " + store.getEmail());
        }catch(IllegalArgumentException e){
            System.out.println("회원가입 실패");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("회원가입 실패");
        }
    }

    /**
     * 스토어 로그인 (JWT 토큰 발급)
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto request) {

        String token =  storeAuthService.login(request);

        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    /**
     * 스토어 로그아웃
     *
     * @return
     */
    @PostMapping("/logout")
    public String logout(@RequestParam String username, @RequestParam String password) {
        return "test";
    }

}
