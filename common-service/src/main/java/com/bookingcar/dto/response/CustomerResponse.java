package com.bookingcar.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerResponse {

    private Long id;
    private String avatar;
    private Boolean gender;
    private Date birthday;
    private String address;
    private UserResponse user;
}
