package com.reservation.reservation_server.dto.product;

import com.reservation.reservation_server.common.ServiceStatus;
import com.reservation.reservation_server.entity.Product;
import com.reservation.reservation_server.entity.ReservationHdr;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductResponseDto {

    private Long productId;
    private String name;
    private String description;
    private String category;
    private Integer price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long storeId;
    private ServiceStatus status;


}
