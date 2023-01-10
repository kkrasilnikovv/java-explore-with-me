package ru.practicum.main_server.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private List<String> errors;

    private String message;

    private String reason;

    private String status;

    private LocalDateTime timestamp;
}
