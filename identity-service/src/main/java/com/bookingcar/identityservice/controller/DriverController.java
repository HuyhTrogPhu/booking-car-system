package com.bookingcar.identityservice.controller;


import com.bookingcar.dto.request.DriverUpdateRequest;
import com.bookingcar.dto.response.ApiResponse;
import com.bookingcar.dto.response.DriverResponse;
import com.bookingcar.identityservice.service.DriverService;
import com.bookingcar.identityservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("booking-car-system/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping
    public ApiResponse<List<DriverResponse>> findAllDrivers() {
        return ApiResponse.<List<DriverResponse>>builder().result(driverService.getAllDrivers()).build();
    }

    @GetMapping("/{driverId}")
    public ApiResponse<DriverResponse> findDriverById(@PathVariable("driverId") @Valid Long driverId) {
        return ApiResponse.<DriverResponse>builder().result(driverService.getDriverById(driverId)).build();
    }

    @PutMapping("/{driverId}")
    public ApiResponse<DriverResponse> updateDriver(@RequestBody @Valid DriverUpdateRequest driverUpdateRequest, @PathVariable("driverId") Long driverId) {
        return ApiResponse.<DriverResponse>builder().result(driverService.updateDriver(driverUpdateRequest, driverId)).build();
    }
}
