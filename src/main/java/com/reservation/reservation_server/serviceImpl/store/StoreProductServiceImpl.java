package com.reservation.reservation_server.serviceImpl.store;

import com.reservation.reservation_server.common.ServiceStatus;
import com.reservation.reservation_server.dto.product.ProductRequsetDto;
import com.reservation.reservation_server.dto.product.ProductResponseDto;
import com.reservation.reservation_server.entity.Product;
import com.reservation.reservation_server.repository.StoreProductRepository;
import com.reservation.reservation_server.service.store.StoreProductService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreProductServiceImpl implements StoreProductService {

    private final StoreProductRepository storeProductRepository;

    @Autowired
    public StoreProductServiceImpl(StoreProductRepository storeProductRepository) {
        this.storeProductRepository = storeProductRepository;
    }


    @Override
    public List<ProductResponseDto> getProduct(Long storeId) {
        List<Product> products = storeProductRepository.findAllByStoreId(storeId);

        return products.stream()
                .map(this::toProductResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductResponseDto getDetailProduct(Long productId, Long storeId) {
        Product product = storeProductRepository.findByProductIdAndStoreId(productId, storeId);
        return toProductResponseDto(product);
    }

    @Transactional
    public Product createProduct(Long storeId, ProductRequsetDto requsetDto) {

        Product product = new Product();
        product.setStoreId(storeId);
        product.setName(requsetDto.getName());
        product.setPrice(requsetDto.getPrice());
//        product.setCategory(requsetDto.getCategory());
        product.setDescription(requsetDto.getDescription());
        product.setStatus(ServiceStatus.CONFIRMED);

        return storeProductRepository.save(product);
    }

    @Transactional
    public Product updateProduct(Long storeId, Long productId, ProductRequsetDto requsetDto) {
        Product product = storeProductRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("상품 없음"));

        product.setStoreId(storeId);

        if (requsetDto.getName() != null) product.setName(requsetDto.getName());
        if (requsetDto.getPrice() != null) product.setPrice(requsetDto.getPrice());
//        if (requsetDto.getCategory() != null) product.setCategory(requsetDto.getCategory());
        if (requsetDto.getDescription() != null) product.setDescription(requsetDto.getDescription());

        product.setStatus(ServiceStatus.CONFIRMED);

        return product;
    }

    @Transactional
    public Product deleteProduct(Long storeId, Long productId) {
        Product product = storeProductRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("상품 없음"));

        // 소유자 체크 필요하면 추가
//        if (!product.getStoreId().equals(storeId)) {
//            throw new RuntimeException("권한 없음");
//        }

        product.setStatus(ServiceStatus.DELETED); // 논리 삭제 처리

        return product; // 트랜잭션 안에서 자동 반영
    }




    // Product를 ProductResponseDto로 변환하는 메서드 예시
    private ProductResponseDto toProductResponseDto(Product product) {
        return ProductResponseDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
//                .category(product.getCategory())
                .price(product.getPrice())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .status(product.getStatus())
                .build();
    }

}
