package com.bookingcar.bookingservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "cancellation_log")
public class CancellationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_id")
    private Long bookingId;

    @Column(columnDefinition = "TEXT")
    private String reason;

    @Column(name = "cancel_by")
    private String cancelBy;

    @Column(name = "cancel_time")
    private LocalDateTime cancelTime;

    @Column(name = "refund_amount")
    private BigDecimal refundAmount;
}
