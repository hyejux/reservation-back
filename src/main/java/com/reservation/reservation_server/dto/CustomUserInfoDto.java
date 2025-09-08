package com.reservation.reservation_server.dto;

import com.reservation.reservation_server.common.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CustomUserInfoDto {

    /**
     * 유저 정보 저장 */
    private Long userId;
    private String email;
    private String password;
    private String name;
    private String phoneNumber;
    private RoleType role;


}
