package ru.practicum.main_server.dto;


import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompilationDto {
    private Long id;

    private List<EventShortDto> events;

    @NotNull
    private String title;

    private boolean pinned;
}
