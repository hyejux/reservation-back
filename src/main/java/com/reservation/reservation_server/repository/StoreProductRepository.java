package com.reservation.reservation_server.repository;

import com.reservation.reservation_server.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByStoreId(Long storeId);
    Product findByProductIdAndStoreId(Long productId, Long storeId);
}
