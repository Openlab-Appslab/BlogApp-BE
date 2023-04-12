package com.example.backend.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BlogWasNotFound extends RuntimeException{
    public BlogWasNotFound(String message){super(message);}
}
