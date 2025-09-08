package com.reservation.reservation_server.serviceImpl.admin;

import com.reservation.reservation_server.entity.Product;
import com.reservation.reservation_server.repository.AdminProductRepository;
import com.reservation.reservation_server.service.admin.AdminProductService;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService {

    private final AdminProductRepository adminProductRepository;

    @Autowired
    public AdminProductServiceImpl(AdminProductRepository adminProductRepository) {
        this.adminProductRepository = adminProductRepository;
    }

    @Override
    public List<Product> findAll() {
        System.out.println(adminProductRepository.findAll());
        return adminProductRepository.findAll();
    }
}
