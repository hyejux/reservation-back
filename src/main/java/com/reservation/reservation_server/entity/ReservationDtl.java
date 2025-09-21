package com.reservation.reservation_server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation_dtl")
public class ReservationDtl {

    @Id
    @Column(name = "reservation_id")
    private Long reservationId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "reservation_id")
    private ReservationHdr reservationHdr;

    @Column(name = "special_requests")
    private String specialRequests;

    @Column(name = "cancellation_policy")
    private String cancellationPolicy;

}
