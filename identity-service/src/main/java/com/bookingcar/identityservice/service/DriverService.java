package com.bookingcar.identityservice.service;

import com.bookingcar.dto.request.DriverUpdateRequest;
import com.bookingcar.dto.response.DriverResponse;
import com.bookingcar.exception.AppException;
import com.bookingcar.exception.ErrorCode;
import com.bookingcar.identityservice.entity.Driver;
import com.bookingcar.identityservice.mapper.DriverMapper;
import com.bookingcar.identityservice.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Transactional
    public DriverResponse updateDriver(DriverUpdateRequest driverUpdateRequest, Long driverId) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new AppException(ErrorCode.DRIVER_NOT_EXISTED));

        driverMapper.updateDriverRequest(driverUpdateRequest, driver);
        return driverMapper.toDriverResponse(driverRepository.save(driver));
    }

    public List<DriverResponse> getAllDrivers() {
        return driverMapper.toDriverResponseList((List<Driver>) driverRepository.findAll());
    }

    public DriverResponse getDriverById(Long driverId) {
        return driverMapper.toDriverResponse(driverRepository.findById(driverId)
                .orElseThrow(() -> new AppException(ErrorCode.DRIVER_NOT_EXISTED)));

    }
}
