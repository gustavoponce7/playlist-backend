package com.gpch.playlistbackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public void illegalArgumentException(IllegalArgumentException e, HttpServletResponse response)  {
        log.error("Exception", e);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        //response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    }
}
