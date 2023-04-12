package com.example.backend.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserWasNotFound extends RuntimeException {
    public UserWasNotFound(String message){super(message);}
}
