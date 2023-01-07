package ru.practicum.main_server.dto;

import lombok.*;
import ru.practicum.main_server.model.Location;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewEventDto {

    @NotBlank
    private String annotation;

    @NotNull
    private long category;

    @NotBlank
    private String description;

    @NotBlank
    private String eventDate;

    @NotNull
    private Location location;

    @NotNull
    private boolean paid;

    @NotNull
    private int participantLimit;

    @NotNull
    private boolean requestModeration;

    private String state;

    @NotBlank
    private String title;
}
