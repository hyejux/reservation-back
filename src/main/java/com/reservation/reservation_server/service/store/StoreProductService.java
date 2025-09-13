package com.reservation.reservation_server.service.store;

import com.reservation.reservation_server.dto.product.ProductRequsetDto;
import com.reservation.reservation_server.dto.product.ProductResponseDto;
import com.reservation.reservation_server.entity.Product;

import java.util.List;

public interface StoreProductService {

    List<ProductResponseDto> getProduct(Long storeId);
    ProductResponseDto getDetailProduct(Long productId, Long storeId);
    Product createProduct(Long storeId, ProductRequsetDto productDto);
    Product updateProduct(Long storeId, Long productId , ProductRequsetDto requsetDto);
    Product deleteProduct(Long storeId, Long productId);
}
