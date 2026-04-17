package com.bookingcar.identityservice.repository;

import com.bookingcar.identityservice.entity.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
}
