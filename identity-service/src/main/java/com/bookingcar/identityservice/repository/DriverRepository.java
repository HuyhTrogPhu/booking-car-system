package com.bookingcar.identityservice.repository;

import com.bookingcar.identityservice.entity.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Long> {
}
