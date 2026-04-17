package com.bookingcar.promotionservice.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "promotion_usage")
public class PromotionUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "promotion_id")
    private Long promotionId;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "booking_id")
    private Long bookingId;
    @Column(name = "use_at")
    private LocalDateTime useAt;
}
