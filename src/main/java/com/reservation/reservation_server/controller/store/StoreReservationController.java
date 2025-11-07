package com.reservation.reservation_server.controller.store;

import com.reservation.reservation_server.config.Security.CustomStoreDetails;

import com.reservation.reservation_server.dto.ReservationResponseDto;
import com.reservation.reservation_server.dto.ReservationStatusUpdateRequest;
import com.reservation.reservation_server.service.store.StoreProductService;
import com.reservation.reservation_server.service.store.StoreReservationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreReservationController {


    private final StoreReservationService storeReservationService;

    @Autowired
    public StoreReservationController(StoreReservationService storeReservationService){
        this.storeReservationService = storeReservationService;
    }

    /**
     * 관리자 예약 조회
     * */
    @GetMapping("/reservations")
    public List<ReservationResponseDto> getReservations(@AuthenticationPrincipal CustomStoreDetails customStoreDetails) {
        Long storeId = customStoreDetails.getId();
        return storeReservationService.getReservations(storeId);
    }

    /**
     * 관리자 상품별 예약 상세 조회
     */
    @GetMapping("/reservations/{reservationId}")
    public ResponseEntity<ReservationResponseDto> getReservationDetail(@PathVariable Long reservationId,
                                          @AuthenticationPrincipal CustomStoreDetails customStoreDetails) {
        Long storeId = customStoreDetails.getId();
        System.out.println("실행됨" + reservationId);
        try {
            ReservationResponseDto dto = storeReservationService.getReservationDetail(storeId, reservationId);
            return ResponseEntity.ok(dto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * 관리자 예약 수정
     */
    @PatchMapping("/reservations/update")
    public ResponseEntity<Void> updateReservation(@RequestBody ReservationStatusUpdateRequest request) {
        storeReservationService.updateReservation(request);
        return ResponseEntity.ok().build(); // 200 OK 반환
    }


    /**
     * 관리자 예약 취소
     */
    @PatchMapping("/reservations/{reservationId}")
    public ResponseEntity<?> cancelReservation(@PathVariable Long reservationId,
                                                @AuthenticationPrincipal CustomStoreDetails customStoreDetails) {
        Long storeId = customStoreDetails.getId();
        try{
            storeReservationService.cancelReservation(reservationId, storeId);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }



    }

}
