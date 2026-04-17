package com.bookingcar.incentiveservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "incentive")
public class Incentive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "driver_id")
    private Long driverId;
    @Column(name = "condition_type")
    private String conditionType;
    @Column(name = "reward_amount")
    private BigDecimal rewardAmount;
    @Column(name = "`period`")
    private String period;
}
