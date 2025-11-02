package com.reservation.reservation_server.repository;


import com.reservation.reservation_server.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductRepository extends JpaRepository<Product,Long> {
    Product findAllByProductId(Long productId);

    List<Product> findByCategory_Id(Long categoryId);
}
