package com.reservation.reservation_server.repository;

import com.reservation.reservation_server.entity.Product;
import com.reservation.reservation_server.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByStore_StoreId(Long storeId);

    Product findByProductIdAndStore_StoreId(Long productId, Long storeId);

    boolean existsByCategoryIdAndStore_StoreId(Long categoryId, Long storeId);

}