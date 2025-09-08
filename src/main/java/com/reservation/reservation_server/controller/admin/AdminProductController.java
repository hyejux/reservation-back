package com.reservation.reservation_server.controller.admin;

import com.reservation.reservation_server.entity.Product;
import com.reservation.reservation_server.service.admin.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminProductController {

    @Autowired
    private AdminProductService adminProductService;

    /**
     * 서비스 조회 */
    @GetMapping("/product")
    public List<Product> getProduct() {
        return adminProductService.findAll();
    }

    /**
     * 서비스 상세 조회 */
    public List<Product> getDetailProduct(){
        return null;
    }

    /**
     * 서비스 등록 */
    @PostMapping("/product")
    public String createProduct() {
        return "test";
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
