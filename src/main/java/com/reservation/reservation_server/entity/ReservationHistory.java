package com.reservation.reservation_server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation_history")
public class ReservationHistory {

    @Id
    @Column(name = "history_id")
    private Long historyId;

    @Column(name = "changed_by")
    private Long changedBy;

    @Column(name = "status_before")
    private String statusBefore;

    @Column(name = "status_after")
    private String statusAfter;

    @Column(name = "changed_at")
    private LocalDateTime changedAt;

    private String reason;

    @Column(name = "reservation_id")
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "reservation_id", insertable = false, updatable = false)
    private ReservationHdr reservationHdr;

    // getters and setters
}
