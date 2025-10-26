package com.reservation.reservation_server.controller.user;

import com.reservation.reservation_server.config.Security.CustomStoreDetails;
import com.reservation.reservation_server.dto.CategoryDto;
import com.reservation.reservation_server.dto.ProductDto;
import com.reservation.reservation_server.dto.product.ProductResponseDto;
import com.reservation.reservation_server.entity.Product;
import com.reservation.reservation_server.service.user.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("")
public class UserProductController {

    private final UserProductService userProductService;

    @Autowired
    public UserProductController(UserProductService userProductService){
        this.userProductService = userProductService;
    }

    @GetMapping("/product")
    public List<ProductDto> getProduct() {
        return userProductService.getProduct();
    }

    /**
     * 서비스 상세 조회 */
    @GetMapping("/product/{productId}")
    public ProductResponseDto getDetailProduct(@PathVariable Long productId) {
//        Long storeId = customStoreDetails.getId(); // 임시 user 로 testing
        System.out.println(productId + "productId");
//        System.out.println(storeId + "storeId");
        return userProductService.getDetailProduct(productId);
    }


    /**
     * 카테고리 조회
     */
    @GetMapping("/product/category")
    public List<CategoryDto> getCategory() {
        return userProductService.getCategory();
    }

}
