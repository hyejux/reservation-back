package com.reservation.reservation_server.controller.admin;

import com.reservation.reservation_server.config.Security.CustomUserDetails;
import com.reservation.reservation_server.dto.product.ProductRequsetDto;
import com.reservation.reservation_server.dto.product.ProductResponseDto;
import com.reservation.reservation_server.entity.User;
import com.reservation.reservation_server.service.admin.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminProductController {

    private final AdminProductService adminProductService;

    @Autowired
    public AdminProductController(AdminProductService adminProductService){
        this.adminProductService = adminProductService;
    }

    /**
     * 서비스 조회 */
    @GetMapping("/product")
    public List<ProductResponseDto> getProduct(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        Long storeId = customUserDetails.getId(); // 임시 user 로 testing
        System.out.println("여기까지 오긴해");
        return adminProductService.getProduct(storeId);
    }

    /**
     * 서비스 상세 조회 */
    @GetMapping("/product/{productId}")
    public ProductResponseDto getDetailProduct(@PathVariable Long productId, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        Long storeId = customUserDetails.getId(); // 임시 user 로 testing
        return adminProductService.getDetailProduct(productId, storeId);
    }

    /**
     * 서비스 등록 */
    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestBody ProductRequsetDto requsetDto) {
        Long storeId = customUserDetails.getId(); // 임시 user 로 testing
        adminProductService.createProduct(storeId, requsetDto);
        return ResponseEntity.ok().build();
    }

    /**
     * 서비스 수정 */
    @PatchMapping("/product/{productId}")
    public String updateProduct(@PathVariable String productId) {
        return "test";
    }

    /**
     * 서비스 삭제 (소프트 삭제 / 비활성화)  */
    @PatchMapping("/product/{productId}/deactivate")
    public String deactivateProduct(@PathVariable String productId) {
        return "test";
    }

}
