package com.reservation.reservation_server.entity;

import com.reservation.reservation_server.common.ReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;

    private LocalDate date;

    private LocalTime time;

    private ReservationStatus status;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @CreationTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "store_id")
    private Long storeId;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "store_id", insertable = false, updatable = false )
    private Store store;

//    @OneToOne(mappedBy = "reservationHdr", cascade = CascadeType.ALL)
//    private ReservationDtl reservationDtl;
//
//    @OneToMany(mappedBy = "reservationHdr")
//    private List<ReservationHistory> reservationHistories;
//
//    @OneToMany(mappedBy = "reservationHdr")
//    private List<Payment> payments;


}
