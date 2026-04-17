package com.bookingcar.bookingservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId; // tham chiếu Customer từ Identity
    @Column(name = "driver_id")
    private Long driverId;
    @Column(name = "sticket_id")
    private Long sticketId;
    @Column(name = "promotion_id")
    private Long promotionId;
    @Column(name = "booking_date")
    private LocalDate bookingDate;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    private String status; // Pending, Complete, Cancel
    @Column(name = "seat_number")
    private String seatNumber;
    @Column(name = "pickup_point")
    private String pickupPoint;
    @Column(name = "drop_off_point")
    private String dropoffPoint;
}
