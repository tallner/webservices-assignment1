package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad input")
public class myException extends Exception {
    private static final long serialVersionUID = 1L;

    public myException(String errorMessage) {
        super(errorMessage);
    }
}