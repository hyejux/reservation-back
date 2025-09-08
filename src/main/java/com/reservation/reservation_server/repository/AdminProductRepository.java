package com.reservation.reservation_server.repository;

import com.reservation.reservation_server.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductRepository extends JpaRepository<Product,Long> {
}
