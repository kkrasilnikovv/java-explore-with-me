package ru.practicum.main_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.main_server.dto.NewUserRequest;
import ru.practicum.main_server.dto.UserDto;
import ru.practicum.main_server.exception.ObjectNotFoundException;
import ru.practicum.main_server.exception.ObjectsConflictException;
import ru.practicum.main_server.mapper.UserMapper;
import ru.practicum.main_server.model.User;
import ru.practicum.main_server.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> getUsers(List<Long> ids, int from, int size) {
        if (ids.isEmpty()) {
            return userRepository.findAll(PageRequest.of(from / size, size))
                    .stream()
                    .map(UserMapper::toUserDto)
                    .collect(Collectors.toList());
        }
        return userRepository.findAllByIdIn(ids, PageRequest.of(from / size, size))
                .stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserDto saveUser(NewUserRequest newUserRequest) {
        if (userRepository.findByName(newUserRequest.getName()).isPresent()) {
            throw new ObjectsConflictException("User with given name already exists");
        }
        return UserMapper.toUserDto(userRepository.save(UserMapper.toUser(newUserRequest)));
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.delete(checkAndGetUser(userId));
    }

    public User checkAndGetUser(long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new ObjectNotFoundException("user with id = " + userId + " not found"));
    }
}
