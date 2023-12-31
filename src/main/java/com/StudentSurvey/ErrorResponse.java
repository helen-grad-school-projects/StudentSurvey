package com.StudentSurvey;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ErrorResponse() {
        timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String message, String details) {
        this();
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}