package ru.practicum.main_server.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Float lat;
    @NotNull
    private Float lon;
    private Float radius;
}