package com.reservation.reservation_server.controller.user;

import com.reservation.reservation_server.config.Security.CustomStoreDetails;
import com.reservation.reservation_server.config.Security.CustomUserDetails;
import com.reservation.reservation_server.dto.ReservationFormDto;
import com.reservation.reservation_server.dto.ReservationResponseDto;
import com.reservation.reservation_server.dto.ReservationSaveResult;

import com.reservation.reservation_server.service.user.UserReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserReservationController {

    private final UserReservationService userReservationService;

    @Autowired
    public UserReservationController(UserReservationService userReservationService) {
        this.userReservationService = userReservationService;
    }


    /**
     * 사용자 예약 조회  */
    @GetMapping("/reservation/my")
    public List<ReservationResponseDto> getMyReservations(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        Long userId = customUserDetails.getId();

        return userReservationService.getReservations(userId);
    }


    /**
     * 사용자 예약 생성
     * - 예약 시간 중복 체크기능
     * POST /reservation?storeId=10&productId=101
     * */
    @PostMapping("/stores/{storeId}/products/{productId}/reservations")
    public ResponseEntity<ReservationSaveResult> createReservation(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                                                   @RequestBody ReservationFormDto dto,
                                                                   @PathVariable Long storeId,
                                                                   @PathVariable Long productId
    ) {
        dto.setStoreId(storeId);
        dto.setProductId(productId);
        dto.setUserId(customUserDetails.getId());

        ReservationSaveResult response = userReservationService.createReservation(dto);

        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * 사용자 예약 취소 */
    @PatchMapping("/reservation/{reservaionId}")
    public String cancelReservation(@PathVariable("reservaionId") String reservaionId){
        return "test";
    }


}
