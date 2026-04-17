package com.bookingcar.communicationservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "chat_message")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_id")
    private Long roomId;
    @Column(name = "sender_id")
    private Long senderId;
    @Column(name = "message_type")
    private String messageType; // text, image, voice

    @Column(columnDefinition = "TEXT")
    private String content; // nullable if image, voice

    @Column(name = "media_url")
    private String mediaUrl; // image or voice

    private Integer duration; // time voice
    @Column(name = "sent_at")
    private LocalDateTime sentAt;
    @Column(name = "is_read")
    private Boolean isRead;
}
