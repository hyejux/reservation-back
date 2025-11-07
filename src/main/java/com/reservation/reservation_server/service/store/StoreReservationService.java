package com.reservation.reservation_server.service.store;

import com.reservation.reservation_server.dto.ReservationFormDto;
import com.reservation.reservation_server.dto.ReservationResponseDto;
import com.reservation.reservation_server.dto.ReservationSaveResult;
import com.reservation.reservation_server.dto.ReservationStatusUpdateRequest;
import com.reservation.reservation_server.entity.ReservationHdr;

import java.util.List;
import java.util.Optional;

public interface StoreReservationService {
    List<ReservationResponseDto> getReservations(Long storeId);
    ReservationResponseDto getReservationDetail(Long userId, Long reservationId);
    ReservationSaveResult createReservation(ReservationFormDto dto);
    void cancelReservation(Long reservationId, Long storeId);
    void updateReservation(ReservationStatusUpdateRequest request);
}
