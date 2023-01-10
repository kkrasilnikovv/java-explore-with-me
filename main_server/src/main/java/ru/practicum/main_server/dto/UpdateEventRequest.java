package ru.practicum.main_server.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEventRequest {
    private Long eventId;

    private String annotation;

    private Long category;

    private String description;

    private String eventDate;

    private Boolean paid;

    private Integer participantLimit;

    private String title;
}
