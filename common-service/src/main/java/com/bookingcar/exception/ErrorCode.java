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
    CUSTOMER_NOT_EXISTED(1005, "Không tìm thấy khách hàng");

    private final int code;
    private final String message;


    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
