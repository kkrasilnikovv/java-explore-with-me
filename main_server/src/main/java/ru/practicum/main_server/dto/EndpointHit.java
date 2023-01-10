package ru.practicum.main_server.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EndpointHit {
    private long id;

    private String app;

    private String uri;

    private String ip;

    private String timestamp;
}
