package ru.practicum.main_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.main_server.model.Location;
import ru.practicum.main_server.repository.LocationRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    @Transactional
    public Location save(Location location) {
        return locationRepository.save(location);
    }
}
