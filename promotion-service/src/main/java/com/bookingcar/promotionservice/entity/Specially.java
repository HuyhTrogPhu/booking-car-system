package com.bookingcar.promotionservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "specially")
public class Specially {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "promotion_id")
    private Long promotionId;
    @Column(name = "from_date")
    private LocalDateTime fromDate;
    @Column(name = "to_date")
    private LocalDateTime toDate;
    @Column(name = "media_url")
    private String mediaUrl;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String type;
}
