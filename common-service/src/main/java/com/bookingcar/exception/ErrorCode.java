package com.bookingcar.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    SUCCESS(1000, "Thành công"),
    UNCATEGORIZED_EXCEPTION(9999, "Lỗi hệ thống không xác định"),
    USER_EXISTED(1001, "Người dùng đã tồn tại"),
    USER_NOT_EXISTED(1002, "Không tìm thấy người dùng"),
    ROLE_NOT_EXISTED(1003, "Không tìm thấy quyền (Role)"),
    DRIVER_NOT_EXISTED(1004, "Không tìm thấy tài xế"),
    CUSTOMER_NOT_EXISTED(1005, "Không tìm thấy khách hàng"),

    // User valid
    INVALID_KEY(1006, "Lỗi định nghĩa invalid key"),
    USERNAME_INVALID(1007, "Username không được để trống và có ít nhât 4 ký tự"),
    PASSWORD_INVALID(1008, "Password không được để trống và phải có ít nhất 6 ký tự"),
    EMAIL_INVALID(1009, "Email không được để trống và phải đúng định dạng"),
    FIRST_NAME_BLANK(1010, "Tên (First Name) không được để trống"),
    LAST_NAME_BLANK(1011, "Họ (Last Name) không được để trống"),
    PHONE_INVALID(1012, "Số điện thoại không được để trống và phải gồm 10 chữ số");

    private final int code;
    private final String message;


    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
