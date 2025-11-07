package com.reservation.reservation_server.service.store;

import com.reservation.reservation_server.dto.CategoryDto;
import com.reservation.reservation_server.dto.product.ProductRequestDto;
import com.reservation.reservation_server.dto.product.ProductRequestDto;
import com.reservation.reservation_server.dto.product.ProductResponseDto;
import com.reservation.reservation_server.entity.Category;
import com.reservation.reservation_server.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StoreProductService {

    List<ProductResponseDto> getProduct(Long storeId);
    ProductResponseDto getDetailProduct(Long productId, Long storeId);
    ProductResponseDto createProduct(Long storeId, ProductRequestDto productDto);
    ProductResponseDto updateProduct(Long storeId, ProductRequestDto requsetDto);
    ProductResponseDto deleteProduct(Long storeId, Long productId);


    List<CategoryDto> getCategories(Long storeId);
    CategoryDto getCategory(Long storeId, Long categoryId);
    CategoryDto createCategory(CategoryDto requestDto);
    CategoryDto updateCategory(Long storeId, CategoryDto requestDto);
    void deleteCategory(Long storeId, Long categoryId);
}
