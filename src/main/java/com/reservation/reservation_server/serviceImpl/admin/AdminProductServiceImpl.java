package com.reservation.reservation_server.serviceImpl.admin;

import com.reservation.reservation_server.common.ServiceStatus;
import com.reservation.reservation_server.dto.product.ProductRequsetDto;
import com.reservation.reservation_server.dto.product.ProductResponseDto;
import com.reservation.reservation_server.entity.Product;
import com.reservation.reservation_server.repository.AdminProductRepository;
import com.reservation.reservation_server.service.admin.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminProductServiceImpl implements AdminProductService {

    private final AdminProductRepository adminProductRepository;

    @Autowired
    public AdminProductServiceImpl(AdminProductRepository adminProductRepository) {
        this.adminProductRepository = adminProductRepository;
    }


    @Override
    public List<ProductResponseDto> getProduct(Long storeId) {
        List<Product> products = adminProductRepository.findAllByStoreId(storeId);

        return products.stream()
                .map(this::toProductResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto getDetailProduct(Long productId, Long storeId) {
        Product product = adminProductRepository.findAllByStoreIdAndProductId(productId, storeId);

        return toProductResponseDto(product);
    }

    @Override
    public ResponseEntity<Product> createProduct(Long storeId, ProductRequsetDto productDto) {

        Product product = new Product();
        product.setStoreId(storeId);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setDescription(productDto.getDescription());
        product.setStatus(ServiceStatus.PENDING);

        return ResponseEntity.ok(adminProductRepository.save(product));
    }

    // Product를 ProductResponseDto로 변환하는 메서드 예시
    private ProductResponseDto toProductResponseDto(Product product) {
        return ProductResponseDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .status(product.getStatus())
                .build();
    }

}
