package com.reservation.reservation_server.service.store;

import com.reservation.reservation_server.dto.StoreResponseDto;

public interface StoreAccountServcie {

    StoreResponseDto getStoreInfo(Long storeId);

}
