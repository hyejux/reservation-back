package com.reservation.reservation_server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_id")
    private Long productId;

    private String name;

    private String description;

    private String category;

    private Integer price;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_active")
    private ServiceStatus isActive;

    @Column(name = "store_id")
    private Long storeId;

    @ManyToOne
    @JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;

    @OneToMany(mappedBy = "product")
    private List<ReservationHdr> reservationHdr;

    // ServiceStatus enum
    public enum ServiceStatus {
        PENDING, CONFIRMED, CANCELLED
    }

    // getters and setters
}
