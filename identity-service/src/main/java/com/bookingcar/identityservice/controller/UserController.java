package com.bookingcar.identityservice.controller;

import com.bookingcar.dto.request.UserCreationRequest;
import com.bookingcar.dto.request.UserUpdateRequest;
import com.bookingcar.dto.response.ApiResponse;
import com.bookingcar.dto.response.UserResponse;
import com.bookingcar.identityservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking-car-system/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest userCreationRequest) {
        return ApiResponse.<UserResponse>builder().result(userService.createUser(userCreationRequest)).build();
    }

    @PutMapping("/{userId}")
    public ApiResponse<UserResponse> updateUser(@PathVariable @Valid Long userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        return ApiResponse.<UserResponse>builder().result(userService.updateUser(userUpdateRequest, userId)).build();
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> findAllUsers() {
        return ApiResponse.<List<UserResponse>>builder().result(userService.getAllUsers()).build();
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserResponse> findUserById(@PathVariable @Valid Long userId) {
        return ApiResponse.<UserResponse>builder().result(userService.getUserById(userId)).build();
    }

}
