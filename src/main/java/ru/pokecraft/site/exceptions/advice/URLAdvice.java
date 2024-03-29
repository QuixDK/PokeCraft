package ru.pokecraft.site.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.pokecraft.site.exceptions.URLException;

import java.net.MalformedURLException;

@RestControllerAdvice
public class URLAdvice {
    @ExceptionHandler(URLException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> malformedURLExceptionHandler(MalformedURLException e) {
        return new ResponseEntity<>("Cannot find url", HttpStatus.BAD_REQUEST);
    }
}
