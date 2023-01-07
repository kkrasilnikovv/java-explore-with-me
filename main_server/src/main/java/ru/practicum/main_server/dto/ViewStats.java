package ru.practicum.main_server.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViewStats {
    private String app;

    private String uri;

    private int hits;
}
