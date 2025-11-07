package com.reservation.reservation_server.dto;


import com.reservation.reservation_server.entity.Category;
import com.reservation.reservation_server.entity.Store;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private Long categoryId;
    private String categoryName;
    private Long storeId;
    private Boolean isActive;

    public static CategoryDto fromEntity(Category category) {
        if (category == null) return null;

        CategoryDto dto = new CategoryDto();
        dto.setCategoryId(category.getId());
        dto.setStoreId(category.getStore().getStoreId());
        dto.setCategoryName(category.getName());
        dto.setIsActive(category.getIsActive());
        return dto;
    }

}
