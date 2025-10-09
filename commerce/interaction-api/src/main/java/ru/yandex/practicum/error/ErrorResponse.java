package ru.yandex.practicum.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ErrorResponse {
    private final int status;
    private final String reason;
    private final List<String> message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime timestamp;

    public ErrorResponse(int status, String reason, List<String> message, LocalDateTime timestamp) {
        this.status = status;
        this.reason = reason;
        this.message = message;
        this.timestamp = timestamp;
    }

    public ErrorResponse(HttpStatus status, String reason, List<String> message) {
        this(status.value(), reason, message, LocalDateTime.now());
    }

    public ErrorResponse(HttpStatus status, String reason, String message) {
        this(status.value(), reason, List.of(message), LocalDateTime.now());
    }
}