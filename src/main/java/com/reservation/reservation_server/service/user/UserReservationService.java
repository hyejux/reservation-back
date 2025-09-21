package com.reservation.reservation_server.service.user;

import com.reservation.reservation_server.dto.ReservationFormDto;
import com.reservation.reservation_server.dto.ReservationResponseDto;
import com.reservation.reservation_server.dto.ReservationSaveResult;

import java.util.List;

public interface UserReservationService {
    List<ReservationResponseDto> getReservations(Long userId);
    ReservationSaveResult createReservation(ReservationFormDto dto);
}
