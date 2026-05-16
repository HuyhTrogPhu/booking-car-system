package com.bookingcar.identityservice.service;

import com.bookingcar.dto.request.CustomerUpdateRequest;
import com.bookingcar.dto.response.CustomerResponse;
import com.bookingcar.exception.AppException;
import com.bookingcar.exception.ErrorCode;
import com.bookingcar.identityservice.entity.Customer;
import com.bookingcar.identityservice.mapper.CustomerMapper;
import com.bookingcar.identityservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public CustomerResponse updateCustomer(CustomerUpdateRequest customerUpdateRequest, Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXISTED));
        customerMapper.updateCustomerRequest(customerUpdateRequest, customer);
        return customerMapper.toCustomerResponse(customerRepository.save(customer));
    }

    public List<CustomerResponse> getAllCustomers() {
        return customerMapper.toCustomerResponseList((List<Customer>) customerRepository.findAll());
    }

    public CustomerResponse getCustomerById(Long customerId) {
        return customerMapper.toCustomerResponse(customerRepository.findById(customerId)
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXISTED)));
    }
}
