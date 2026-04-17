package com.bookingcar.identityservice.service;

import com.bookingcar.dto.request.UserCreationRequest;
import com.bookingcar.dto.request.UserUpdateRequest;
import com.bookingcar.dto.response.UserResponse;
import com.bookingcar.exception.AppException;
import com.bookingcar.exception.ErrorCode;
import com.bookingcar.identityservice.entity.Customer;
import com.bookingcar.identityservice.entity.Driver;
import com.bookingcar.identityservice.entity.Role;
import com.bookingcar.identityservice.entity.User;
import com.bookingcar.identityservice.mapper.UserMapper;
import com.bookingcar.identityservice.repository.CustomerRepository;
import com.bookingcar.identityservice.repository.DriverRepository;
import com.bookingcar.identityservice.repository.RoleRepository;
import com.bookingcar.identityservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CustomerRepository customerRepository;
    private final DriverRepository driverRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Transactional
    public UserResponse createUser(UserCreationRequest userCreationRequest) {
        if (userRepository.existsByUsername(userCreationRequest.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        Role role = roleRepository.findById(userCreationRequest.getRole())
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_EXISTED));

        User user = userMapper.toUser(userCreationRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role);
        user.setUsername(userCreationRequest.getUsername());
        user.setEmail(userCreationRequest.getEmail());
        user.setActive(true);
        User savedUser = userRepository.save(user);

        if (userCreationRequest.getRole() == 2) {
            Driver driver = new Driver();
            driver.setFirstName(userCreationRequest.getFirstName());
            driver.setLastName(userCreationRequest.getLastName());
            driver.setPhoneNumber(String.valueOf(userCreationRequest.getPhoneNumber()));
            driver.setUser(savedUser);
            driverRepository.save(driver);
        } else if (userCreationRequest.getRole() == 3) {
            Customer customer = new Customer();
            customer.setFirstName(userCreationRequest.getFirstName());
            customer.setLastName(userCreationRequest.getLastName());
            customer.setPhoneNumber(String.valueOf(userCreationRequest.getPhoneNumber()));
            customer.setUser(savedUser);
            customerRepository.save(customer);
        }

        return userMapper.toUserResponse(savedUser);
    }

    @Transactional
    public UserResponse updateUser(UserUpdateRequest userUpdateRequest, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        userMapper.updateUser(userUpdateRequest, user);
        if (userUpdateRequest.getPassword() != null && !userUpdateRequest.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userUpdateRequest.getPassword()));
        }

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<UserResponse> getAllUsers() {
        return userMapper.toUserResponseList((List<User>) userRepository.findAll());
    }

    public UserResponse getUserById(Long id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }
}
