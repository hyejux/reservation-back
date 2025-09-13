package com.reservation.reservation_server.controller.store;

import com.reservation.reservation_server.config.Security.CustomStoreDetails;
import com.reservation.reservation_server.config.Security.CustomUserDetails;
import com.reservation.reservation_server.dto.product.ProductRequsetDto;
import com.reservation.reservation_server.dto.product.ProductResponseDto;
import com.reservation.reservation_server.entity.Product;
import com.reservation.reservation_server.service.store.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreProductController {

    private final StoreProductService storeProductService;

    @Autowired
    public StoreProductController(StoreProductService storeProductService){
        this.storeProductService = storeProductService;
    }

    /**
     * 서비스 조회 */
    @GetMapping("/product")
    public List<ProductResponseDto> getProduct(@AuthenticationPrincipal CustomStoreDetails customStoreDetails) {
        Long storeId = customStoreDetails.getId(); // 임시 user 로 testing
        System.out.println("여기까지 오긴해");
        return storeProductService.getProduct(storeId);
    }

    /**
     * 서비스 상세 조회 */
    @GetMapping("/product/{productId}")
    public ProductResponseDto getDetailProduct(@PathVariable Long productId, @AuthenticationPrincipal CustomStoreDetails customStoreDetails) {
        Long storeId = customStoreDetails.getId(); // 임시 user 로 testing
        return storeProductService.getDetailProduct(productId, storeId);
    }

    /**
     * 서비스 등록 */
    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@AuthenticationPrincipal CustomStoreDetails customStoreDetails, @RequestBody ProductRequsetDto requsetDto) {
        Long storeId = customStoreDetails.getId(); // 임시 user 로 testing
        storeProductService.createProduct(storeId, requsetDto);

        Product createdProduct = storeProductService.createProduct(storeId, requsetDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdProduct.getProductId())
                .toUri();

        return ResponseEntity.created(location).body(createdProduct);
    }

    /**
     * 서비스 수정 */
    @PatchMapping("/product/{productId}")
    public ResponseEntity<?> updateProduct(@AuthenticationPrincipal CustomStoreDetails customStoreDetails, @PathVariable Long productId, @RequestBody ProductRequsetDto requsetDto) {
        Long storeId = customStoreDetails.getId(); // 임시 user 로 testing 중
        Product updatedProduct = storeProductService.updateProduct(storeId, productId, requsetDto);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * 서비스 삭제 (소프트 삭제 / 비활성화)  deactivateProduct */
    @PatchMapping("/product/{productId}/delete")
    public ResponseEntity<Void> deleteProduct(@AuthenticationPrincipal CustomStoreDetails customStoreDetails, @PathVariable Long productId) {
        Long storeId = customStoreDetails.getId(); // 임시 user 로 testing 중
        Product deleteProduct = storeProductService.deleteProduct(storeId, productId);
        return ResponseEntity.noContent().build();
    }

}
