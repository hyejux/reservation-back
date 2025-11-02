package com.reservation.reservation_server.serviceImpl.user;

import com.reservation.reservation_server.common.ServiceStatus;
import com.reservation.reservation_server.dto.CategoryDto;
import com.reservation.reservation_server.dto.ProductDto;
import com.reservation.reservation_server.dto.product.ProductRequsetDto;
import com.reservation.reservation_server.dto.product.ProductResponseDto;
import com.reservation.reservation_server.entity.Category;
import com.reservation.reservation_server.entity.Product;
import com.reservation.reservation_server.repository.CategoryRepository;
import com.reservation.reservation_server.repository.StoreProductRepository;
import com.reservation.reservation_server.repository.UserProductRepository;
import com.reservation.reservation_server.service.store.StoreProductService;
import com.reservation.reservation_server.service.user.UserProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProductServiceImpl implements UserProductService {

    private final UserProductRepository userProductRepository;
    private final  CategoryRepository categoryRepository;

    @Autowired
    public UserProductServiceImpl(UserProductRepository userProductRepository,  CategoryRepository categoryRepository) {
        this.userProductRepository = userProductRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductDto> getProduct() {
        return userProductRepository.findAll().stream()
                .map(product -> new ProductDto(
                        product.getProductId(),
                        product.getStoreId(),
                        product.getStore() != null ? product.getStore().getName() : null, // 가게명
                        product.getName(),
                        product.getDescription(),
                        product.getCategory() != null ? product.getCategory().getName() : null, // 카테고리 이름
                        product.getPrice(),
                        product.getStatus(),
                        product.getCreatedAt() != null ? product.getCreatedAt().toString() : null,
                        product.getUpdatedAt() != null ? product.getUpdatedAt().toString() : null
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductsByCategory(Long categoryId) {
        List<Product> products = userProductRepository.findByCategory_Id(categoryId);

        return products.stream()
                .map(product -> new ProductDto(
                        product.getProductId(),
                        product.getStoreId(),
                        product.getStore() != null ? product.getStore().getName() : null,
                        product.getName(),
                        product.getDescription(),
                        product.getCategory() != null ? product.getCategory().getName() : null,
                        product.getPrice(),
                        product.getStatus(),
                        product.getCreatedAt() != null ? product.getCreatedAt().toString() : null,
                        product.getUpdatedAt() != null ? product.getUpdatedAt().toString() : null
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductResponseDto getDetailProduct(Long productId) {
        Product product = userProductRepository.findAllByProductId(productId);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        return ProductResponseDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory() != null
                        ? new Category(product.getCategory().getId(), product.getCategory().getName())
                        : null)
                .price(product.getPrice())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .status(product.getStatus())
                .storeId(product.getStoreId())
                .build();
    }

    @Transactional
    public List<CategoryDto> getCategory() {

        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(c -> new CategoryDto(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }


}
