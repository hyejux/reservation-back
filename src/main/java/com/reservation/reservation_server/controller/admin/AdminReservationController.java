package com.reservation.reservation_server.controller.admin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminReservationController {

    /**
     * 관리자 예약 조회
     * */
    @GetMapping("/reservations")
    public String getReservations() {
        return "test";
    }

    /**
     * 관리자 상품별 예약 상세 조회
     */
    @GetMapping("/reservations/{reservationId}")
    public String getReservationByService(@PathVariable String reservationId) {
        return "test";
    }

    /**
     * 관리자 예약 수정
     */
    @PostMapping
    public void updateReservation(){

    }

    /**
     * 관리자 예약 취소
     */
    @PatchMapping("/reservation/{reservationId}")
    public String cancelReservation(@PathVariable String reservationId, @RequestBody String reservation) {
        return "test";
    }

}
