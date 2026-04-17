package com.bookingcar.bookingservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "sticket")
public class Sticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_id")
    private Long carId;
    @Column(name = "route_id")
    private Long routeId;
    @Column(name = "driver_id")
    private Long driverId;
    @Column(name = "running_date")
    private LocalDate runningDate;
    @Column(name = "running_time")
    private LocalTime runningTime;
    private BigDecimal price;
    @Column(name = "available_seats")
    private Integer availableSeats;
    @Column(name = "sticket_status")
    private String sticketStatus;
}
