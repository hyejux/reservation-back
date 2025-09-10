package com.reservation.reservation_server.dto.auth;

import com.reservation.reservation_server.common.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    /**
     * 유저 정보 저장 */
    private Long userId;
    private String email;
    private String name;
    private String phoneNumber;
    private RoleType role;



}
