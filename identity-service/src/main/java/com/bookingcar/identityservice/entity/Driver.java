package com.bookingcar.identityservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "driver")
public class Driver extends User {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "license_number")
    private String licenseNumber;
    private String status;
    @Column(name = "my_trip")
    private Integer myTrip;
    @Column(name = "total_distance")
    private Double totalDistance;
    private BigDecimal balance;

}
