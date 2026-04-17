package com.bookingcar.incentiveservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "history")
public class IncentiveHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer historyId;

    @Column(name = "driver_id")
    private Long driverId;
    @Column(name = "incentive_id")
    private Long incentiveId;
    @Column(name = "amount_earned")
    private BigDecimal amountEarned;
    @Column(name = "earn_at")
    private LocalDateTime earnAt;

    private String status;
}