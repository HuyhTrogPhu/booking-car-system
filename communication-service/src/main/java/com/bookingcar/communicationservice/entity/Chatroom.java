package com.bookingcar.communicationservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "chatroom")
public class Chatroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "participant_one_id")
    private Long participantOneId;
    @Column(name = "participant_two_id")
    private Long participantTwoId;
    @Column(name = "booking_id")
    private Long bookingId;
    @Column(name = "create_at")
    private LocalDate createAt;
    private String status; // open, close

}
