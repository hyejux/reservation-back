package com.reservation.reservation_server.controller.store;


import com.reservation.reservation_server.config.Security.CustomStoreDetails;
import com.reservation.reservation_server.config.Security.CustomUserDetails;
import com.reservation.reservation_server.dto.StoreResponseDto;
import com.reservation.reservation_server.dto.UserResponseDto;
import com.reservation.reservation_server.service.user.StoreAccountServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreAccountController {

    private final StoreAccountServcie storeAccountServcie;

    @Autowired
    public StoreAccountController(StoreAccountServcie storeAccountServcie) {
        this.storeAccountServcie = storeAccountServcie;
    }

    /**
     * 관리자 프로필 조회 및 권한 정보 조회
     */
    @GetMapping("/me")
    public ResponseEntity<StoreResponseDto> getStoreInfo(@AuthenticationPrincipal CustomStoreDetails customStoreDetails){
        StoreResponseDto storeInfo = storeAccountServcie.getStoreInfo(customStoreDetails.getId());
        return ResponseEntity.status(HttpStatus.OK).body(storeInfo);
    }

    /**
     * 이외의 관리자 계정 관리 (생성,삭제,수정 등등..)
     */

}
