package com.bookingcar.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DriverUpdateRequest {

    private String licenseNumber;
    private String status;
    private Integer myTrip;
    private Double totalDistance;
    private BigDecimal balance;
}
