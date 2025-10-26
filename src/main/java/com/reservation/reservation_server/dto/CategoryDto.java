package com.reservation.reservation_server.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private Long category_id;
    private String category_name;

}
