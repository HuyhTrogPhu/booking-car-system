package com.bookingcar.bookingservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_id")
    private Long bookingId;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "driver_id")
    private Long driverId;

    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String comment;
}
