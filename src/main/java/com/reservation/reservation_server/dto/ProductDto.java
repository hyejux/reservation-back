package com.reservation.reservation_server.dto;

import com.reservation.reservation_server.common.ServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long productId;
    private Long storeId;
    private String storeName;     // 가게명 표시용
    private String name;
    private String description;
    private String category;
    private Integer price;
    private ServiceStatus status;
    private String createdAt;
    private String updatedAt;
}
