package com.bookingcar.identityservice.controller;

import com.bookingcar.dto.request.CustomerUpdateRequest;
import com.bookingcar.dto.response.ApiResponse;
import com.bookingcar.dto.response.CustomerResponse;
import com.bookingcar.dto.response.DriverResponse;
import com.bookingcar.identityservice.entity.Customer;
import com.bookingcar.identityservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("booking-car-service/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ApiResponse<List<CustomerResponse>> getAllCustomer() {
        return ApiResponse.<List<CustomerResponse>>builder().result(customerService.getAllCustomers()).build();
    }

    @GetMapping("/{customerId}")
    public ApiResponse<CustomerResponse> getCustomerById(@PathVariable("customerId") Long customerId) {
        return ApiResponse.<CustomerResponse>builder().result(customerService.getCustomerById(customerId)).build();
    }

    @PutMapping("/{customerId}")
    public ApiResponse<CustomerResponse> updateCustomer(@RequestBody CustomerUpdateRequest customerUpdateRequest, @PathVariable("customerId") Long customerId) {
        return ApiResponse.<CustomerResponse>builder().result(customerService.updateCustomer(customerUpdateRequest, customerId)).build();
    }
}
