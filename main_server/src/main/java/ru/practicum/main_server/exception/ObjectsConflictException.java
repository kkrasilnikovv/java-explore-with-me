package ru.practicum.main_server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ObjectsConflictException extends RuntimeException{
    public ObjectsConflictException(String message){
        super(message);
    }
}
