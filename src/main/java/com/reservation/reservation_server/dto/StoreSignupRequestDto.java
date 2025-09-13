package com.reservation.reservation_server.dto;


import com.reservation.reservation_server.common.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreSignupRequestDto {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String ownerName;

    @NotBlank
    private String phoneNumber;

    private String address;

    private String description;

    private String category;

    @NotBlank
    private String bizRegistrationNum;

    @NotBlank
    private RoleType role;
}