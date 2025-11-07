package com.reservation.reservation_server.dto;

import com.reservation.reservation_server.common.ReservationStatus;
import com.reservation.reservation_server.common.ServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationStatusUpdateRequest {
    private Long reservationId;
    private ReservationStatus status;
}
