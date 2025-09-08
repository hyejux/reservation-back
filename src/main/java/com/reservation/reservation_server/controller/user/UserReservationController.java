package com.reservation.reservation_server.controller.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserReservationController {


    /**
     * 사용자 예약 조회  */
    @GetMapping("/reservation/my")
    public String getMyReservations(){
        return "test";
    }


    /**
     * 사용자 예약 생성
     * - 예약 시간 중복 체크기능
     * */
    @PostMapping("/reservation")
    public String createReservation() {
        return "test";
    }


    /**
     * 사용자 예약 취소 */
    @PatchMapping("/reservation/{reservaionId}")
    public String cancelReservation(@PathVariable("reservaionId") String reservaionId){
        return "test";
    }


}
