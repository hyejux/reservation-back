package com.reservation.reservation_server.service.admin;

import com.reservation.reservation_server.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminProductService {

    List<Product> findAll();

}
