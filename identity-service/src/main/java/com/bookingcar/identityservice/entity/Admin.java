package com.bookingcar.identityservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "admin")
public class Admin extends User {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String avatar;
    @Column(name = "phone_number")
    private String phoneNumber;
    private Boolean gender;
}
