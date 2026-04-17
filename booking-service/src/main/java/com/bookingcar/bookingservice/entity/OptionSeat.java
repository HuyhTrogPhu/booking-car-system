package com.bookingcar.bookingservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "option_seat")
public class OptionSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "car_id")
    private Long carId;
    private Integer normal;
    private Integer special;
}
