package com.reservation.reservation_server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation_hdr")
public class ReservationHdr {

    @Id
    @Column(name = "reservation_id")
    private Long reservationId;

    private LocalDate date;

    private LocalTime time;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_active")
    private ReservationStatus isActive;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "service_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private Product product;

    @OneToOne(mappedBy = "reservationHdr", cascade = CascadeType.ALL)
    private ReservationDtl reservationDtl;

    @OneToMany(mappedBy = "reservationHdr")
    private List<ReservationHistory> reservationHistories;

    @OneToMany(mappedBy = "reservationHdr")
    private List<Payment> payments;

    // ReservationStatus enum
    public enum ReservationStatus {
        PENDING, CONFIRMED, CANCELLED
    }

    // getters and setters
}
