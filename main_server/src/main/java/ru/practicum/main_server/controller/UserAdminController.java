package ru.practicum.main_server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.main_server.dto.NewUserRequest;
import ru.practicum.main_server.dto.UserDto;
import ru.practicum.main_server.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "admin/users")
@Slf4j
@RequiredArgsConstructor
public class UserAdminController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers(
            @RequestParam(required = false) List<Long> ids,
            @RequestParam(defaultValue = "0", required = false) int from,
            @RequestParam(defaultValue = "10", required = false) int size) {
        log.info("get users");
        return userService.getUsers(ids, from, size);
    }

    @PostMapping
    public UserDto saveUser(@Validated @RequestBody NewUserRequest newUserRequest) {
        log.info("save user");
        return userService.saveUser(newUserRequest);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        log.info("delete user{}", userId);
        userService.deleteUser(userId);
    }
}
