package com.bookingcar.identityservice.mapper;

import com.bookingcar.dto.request.UserCreationRequest;
import com.bookingcar.dto.request.UserUpdateRequest;
import com.bookingcar.dto.response.UserResponse;
import com.bookingcar.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "password", ignore = true)
    void updateUser(UserUpdateRequest request, @MappingTarget User user);

    List<UserResponse> toUserResponseList(List<User> users);
}
