package io.github.anthogdn.iataaa.checkersApi.controller;

import io.github.anthogdn.iataaa.checkersApi.exception.NotAuthorizedException;
import io.github.anthogdn.iataaa.checkersDto.error.NotAuthorizedDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NotAuthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public NotAuthorizedDto handleNotFoundException(NotAuthorizedException exception) {
        return new NotAuthorizedDto(exception.getCode().toString(), exception.getMessage());
    }
}
