package ru.practicum.main_server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.main_server.dto.CompilationDto;
import ru.practicum.main_server.service.CompilationService;

import java.util.List;

@RestController
@RequestMapping(path = "/compilations")
@Slf4j
@RequiredArgsConstructor
public class CompilationPublicController {
    private final CompilationService compilationService;

    @GetMapping()
    List<CompilationDto> getCompilations(@RequestParam(defaultValue = "true") Boolean pinned,
                                         @RequestParam(defaultValue = "0") int from,
                                         @RequestParam(defaultValue = "10") int size) {
        log.info("get compilations pinned {}", pinned);
        return compilationService.getCompilations(pinned, from, size);
    }

    @GetMapping("/{id}")
    CompilationDto getCompilationById(@PathVariable long id) {
        log.info("get compilation id={}", id);
        return compilationService.getCompilationById(id);
    }
}
