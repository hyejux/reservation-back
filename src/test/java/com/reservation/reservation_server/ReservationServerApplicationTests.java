package com.reservation.reservation_server;

import com.reservation.reservation_server.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ReservationServerApplicationTests {

//    @Autowired
//    private StoreRepository repository;

    @Test
    void contextLoads() {

    }
//
//    @Test
//    public void testCreate() {
//        Stores store = new Stores();
//        store.setName("새 스토어");
//        store.setOwnerName("대표명");
//        store.setPhoneNumber("010-9876-5432");
//        store.setAddress("주소");
//        store.setDescription("설명");
//        store.setCategory("카테고리");
//        store.setBizRegistrationNum("123456789");
//        store.setIsApproved(true);
//
//        Stores savedStore = repository.save(store);
//        System.out.println("생성 완료: " + savedStore);
//    }
//
//    @Test
//    public void testRead() {
//        Long id = 1L; // 조회할 store_id를 설정
//        Optional<Stores> storeOptional = repository.findById(id);
//        storeOptional.ifPresentOrElse(
//                store -> System.out.println("조회 성공: " + store.getStoreId()),
//                () -> System.out.println("해당 ID의 스토어가 없습니다.")
//        );
//    }
//
//    @Test
//    public void testUpdate() {
//        Long id = 1L; // 수정할 store_id
//        Optional<Stores> storeOptional = repository.findById(id);
//        storeOptional.ifPresent(store -> {
//            store.setName("수정된 스토어명");
//            store.setIsApproved(false);
//            Stores updatedStore = repository.save(store);
//            System.out.println("수정 완료: " + updatedStore);
//        });
//    }
//
//    @Test
//    public void testDelete() {
//        Long id = 1L; // 삭제할 store_id
////        repository.deleteById(id);
//        System.out.println("삭제 완료: id = " + id);
//    }

}

