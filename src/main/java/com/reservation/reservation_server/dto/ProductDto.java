package com.reservation.reservation_server.dto;

import com.reservation.reservation_server.common.ServiceStatus;
import com.reservation.reservation_server.entity.Product;
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

    public static ProductDto fromEntity(Product product) {
        if (product == null) return null;

        Long storeId = product.getStore() != null ? product.getStore().getStoreId() : null;
        String storeName = product.getStore() != null ? product.getStore().getName() : null;
        String categoryName = product.getCategory() != null ? product.getCategory().getName() : null;
        String createdAt = product.getCreatedAt() != null ? product.getCreatedAt().toString() : null;
        String updatedAt = product.getUpdatedAt() != null ? product.getUpdatedAt().toString() : null;

        return new ProductDto(
                product.getProductId(),
                storeId,
                storeName,
                product.getName(),
                product.getDescription(),
                categoryName,
                product.getPrice(),
                product.getStatus(),
                createdAt,
                updatedAt
        );
    }
}




