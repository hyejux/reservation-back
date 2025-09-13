package com.reservation.reservation_server.repository;



import com.reservation.reservation_server.entity.Store;
import com.reservation.reservation_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findByEmail(String email);
    Optional<Store> findByStoreId(Long storeId);


}
