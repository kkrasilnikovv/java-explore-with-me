package ru.practicum.main_server.dto;

import lombok.*;
import ru.practicum.main_server.model.Location;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUpdateEventRequest {

    private String annotation;

    private Long category;

    private String description;

    private String eventDate;

    private Location location;

    private Boolean paid;

    private Integer participantLimit;

    private Boolean requestModeration;

    private String title;
}
