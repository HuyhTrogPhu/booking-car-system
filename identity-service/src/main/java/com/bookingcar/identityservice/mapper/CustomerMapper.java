package com.bookingcar.identityservice.mapper;

import com.bookingcar.dto.request.CustomerUpdateRequest;
import com.bookingcar.dto.response.CustomerResponse;
import com.bookingcar.identityservice.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponse toCustomerResponse(Customer customer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateCustomerRequest(CustomerUpdateRequest request, @MappingTarget Customer customer);
}
