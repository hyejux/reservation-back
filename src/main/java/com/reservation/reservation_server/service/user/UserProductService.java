package com.reservation.reservation_server.service.user;


import com.reservation.reservation_server.dto.CategoryDto;
import com.reservation.reservation_server.dto.ProductDto;
import com.reservation.reservation_server.dto.product.ProductResponseDto;
import com.reservation.reservation_server.entity.Product;

import java.util.List;

public interface UserProductService {
    List<ProductDto> getProduct();
    ProductResponseDto getDetailProduct(Long productId);
    List<CategoryDto> getCategory();
}
