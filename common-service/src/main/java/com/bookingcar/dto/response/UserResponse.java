package com.bookingcar.dto.response;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private Boolean isActive;

}
