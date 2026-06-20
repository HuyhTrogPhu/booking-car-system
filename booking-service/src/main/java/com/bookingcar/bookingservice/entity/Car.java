package com.bookingcar.bookingservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "car_number")
    private String carNumber;
    @Column(name = "car_type")
    private String carType;
    @Column(name = "route_ic")
    private Long routeId;
    private Integer seats;
}
