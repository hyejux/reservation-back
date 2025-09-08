package com.reservation.reservation_server.controller.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/auth")
public class AdminAuthController {

    /**
     * 관리자 로그인 기능 (JWT 토큰 발급)
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return "test";
    }

    /**
     * 관리자 로그아웃 기능 (토큰 만료 처리)
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/logout")
    public String logout(@RequestParam String username, @RequestParam String password) {
        return "test";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password) {
        return "test";
    }
}
