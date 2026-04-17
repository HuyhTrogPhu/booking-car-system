package com.bookingcar.communicationservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "call_log")
public class CallLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "caller_id")
    private Long callerId;
    @Column(name = "receiver_id")
    private Long receiverId;
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    private Integer duration;
    private String status;
}
