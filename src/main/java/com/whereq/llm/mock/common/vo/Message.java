package com.whereq.llm.mock.common.vo;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {

    private UUID id;
    private String body;
    private LocalDateTime sentAt;

    public Message() {}

    public Message(UUID id, String body, LocalDateTime sentAt) {
        this.id = id;
        this.body = body;
        this.sentAt = sentAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", body='" + body + '\'' + ", sentAt=" + sentAt + '}';
    }
}
