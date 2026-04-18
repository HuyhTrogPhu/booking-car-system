package com.bookingcar.identityservice.mapper;

import com.bookingcar.dto.request.DriverUpdateRequest;
import com.bookingcar.dto.response.DriverResponse;
import com.bookingcar.identityservice.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    DriverResponse toDriverResponse(Driver driver);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateDriverRequest(DriverUpdateRequest request, @MappingTarget Driver driver);

    List<DriverResponse> toDriverResponseList(List<Driver> drivers);
}
