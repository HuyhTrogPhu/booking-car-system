package com.bookingcar.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerUpdateRequest {

    private String avatar;
    private Boolean gender;
    private Date birthday;
    private String address;
}
