package com.reservation.reservation_server.controller.store;

import com.reservation.reservation_server.config.Security.CustomStoreDetails;
import com.reservation.reservation_server.dto.CategoryDto;
import com.reservation.reservation_server.dto.product.ProductRequestDto;
import com.reservation.reservation_server.dto.product.ProductResponseDto;
import com.reservation.reservation_server.entity.Category;
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
    @GetMapping("/products")
    public List<ProductResponseDto> getProduct(@AuthenticationPrincipal CustomStoreDetails customStoreDetails) {
        Long storeId = customStoreDetails.getId();
        System.out.println("여기까지 오긴해" + storeId);
        return storeProductService.getProduct(storeId);
    }

    /**
     * 서비스 상세 조회 */
    @GetMapping("/products/{productId}")
    public ProductResponseDto getDetailProduct(@PathVariable Long productId, @AuthenticationPrincipal CustomStoreDetails customStoreDetails) {
        Long storeId = customStoreDetails.getId();
        System.out.println(productId + "productId");
        System.out.println(storeId + "storeId");
        return storeProductService.getDetailProduct(productId, storeId);
    }

    /**
     * 서비스 등록 */
    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@AuthenticationPrincipal CustomStoreDetails customStoreDetails,
                                           @RequestBody ProductRequestDto requestDto) {
        Long storeId = customStoreDetails.getId(); // 임시 user 로 testing
//        storeProductService.createProduct(storeId, requestDto);

        ProductResponseDto createdProduct = storeProductService.createProduct(storeId, requestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdProduct.getProductId())
                .toUri();

        return ResponseEntity.created(location).body(createdProduct);
    }

    /**
     * 서비스 수정 */
    @PatchMapping("/products")
    public ResponseEntity<?> updateProduct(@AuthenticationPrincipal CustomStoreDetails customStoreDetails , @RequestBody ProductRequestDto requestDto) {
        Long storeId = customStoreDetails.getId(); // 임시 user 로 testing 중
        ProductResponseDto updatedProduct = storeProductService.updateProduct(storeId, requestDto);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * 서비스 삭제 (소프트 삭제 / 비활성화)  deactivateProduct */
    @PatchMapping("/product/{productId}/delete")
    public ResponseEntity<Void> deleteProduct(@AuthenticationPrincipal CustomStoreDetails customStoreDetails, @PathVariable Long productId) {
        Long storeId = customStoreDetails.getId(); // 임시 user 로 testing 중
        ProductResponseDto deleteProduct = storeProductService.deleteProduct(storeId, productId);
        return ResponseEntity.noContent().build();
    }



    /** -------------------------------------
     * 카테고리(Category) 관련 API
     * ------------------------------------- */

    // 카테고리 전체 조회
    @GetMapping("/categories")
    public List<CategoryDto> getCategories(@AuthenticationPrincipal CustomStoreDetails customStoreDetails) {
        Long storeId = customStoreDetails.getId();
        return storeProductService.getCategories(storeId);
    }

    // 카테고리 단일 조회
    @GetMapping("/categories/{categoryId}")
    public CategoryDto getCategory(@PathVariable Long categoryId, @AuthenticationPrincipal CustomStoreDetails customStoreDetails) {
        Long storeId = customStoreDetails.getId();
        return storeProductService.getCategory(storeId, categoryId);
    }

    // 카테고리 생성
    @PostMapping("/categories")
    public ResponseEntity<?> createCategory(@AuthenticationPrincipal CustomStoreDetails customStoreDetails, @RequestBody CategoryDto requestDto) {
        Long storeId = customStoreDetails.getId();
        requestDto.setStoreId(storeId);
        CategoryDto categoryDto =  storeProductService.createCategory(requestDto);
        return ResponseEntity.noContent().build();
    }

    // 카테고리 수정
    @PatchMapping("/categories")
    public ResponseEntity<?> updateCategory(@AuthenticationPrincipal CustomStoreDetails customStoreDetails, @RequestBody CategoryDto requestDto) {
        Long storeId = customStoreDetails.getId();
        CategoryDto updatedCategory = storeProductService.updateCategory(storeId, requestDto);
        return ResponseEntity.ok(updatedCategory);
    }

    // 카테고리 삭제 (soft delete or hard delete)
    @PatchMapping("/categories/{categoryId}/delete")
    public ResponseEntity<?> deleteCategory(@AuthenticationPrincipal CustomStoreDetails customStoreDetails,
                                            @PathVariable Long categoryId) {
        Long storeId = customStoreDetails.getId();
        try {
            storeProductService.deleteCategory(storeId, categoryId);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e) {
            // 상품이 존재하면 400 Bad Request
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }



}
