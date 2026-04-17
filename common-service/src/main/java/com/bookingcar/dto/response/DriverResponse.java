package com.bookingcar.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DriverResponse {

    private String licenseNumber;
    private String status;
    private Integer myTrip;
    private Double totalDistance;
    private BigDecimal balance;
    private UserResponse user;
}
