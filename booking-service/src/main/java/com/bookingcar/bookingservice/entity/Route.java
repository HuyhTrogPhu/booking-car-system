package com.bookingcar.bookingservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`to`")
    private String to;

    @Column(name = "`from`")
    private String from;

    private Double distance;
}
