package com.reservation.reservation_server.service.user;

import com.reservation.reservation_server.dto.StoreResponseDto;
import com.reservation.reservation_server.dto.UserResponseDto;

public interface StoreAccountServcie {

    StoreResponseDto getStoreInfo(Long storeId);

}
