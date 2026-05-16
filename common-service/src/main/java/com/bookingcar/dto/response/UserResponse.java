package com.bookingcar.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    
    @NotBlank(message = "USERNAME_INVALID")
    @Size(min = 4, message = "USERNAME_INVALID")
    private String username;

    @NotBlank(message = "PASSWORD_INVALID")
    @Size(min = 6, message = "PASSWORD_INVALID")
    private String password;

    @NotBlank(message = "EMAIL_INVALID")
    @Email(message = "EMAIL_INVALID")
    private String email;

    @NotBlank(message = "FIRST_NAME_BLANK")
    private String firstName;

    @NotBlank(message = "LAST_NAME_BLAK")
    private String lastName;

    @NotBlank(message = "PHONE_INVALID")
    @Pattern(regexp = "^\\d{10}$", message = "PHONE_VALID")
    private String phoneNumber;

    private Boolean isActive;

}
