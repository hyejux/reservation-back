package com.reservation.reservation_server.controller.admin;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminAccountController {

    /**
     * 관리자 프로필 조회 및 권한 정보 조회
     */
    @GetMapping
    public void getAdminInfo(){

    }

    /**
     * 이외의 관리자 계정 관리 (생성,삭제,수정 등등..)
     */

}
