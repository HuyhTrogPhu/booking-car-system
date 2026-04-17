package com.bookingcar.identityservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "customer")
public class Customer extends User {

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

    private String avatar;
    @Column(name = "phone_number")
    private String phoneNumber;
    private Boolean gender;
    private Date birthday;
    private String address;

}
