package com.bookingcar.identityservice.repository;

import com.bookingcar.identityservice.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
