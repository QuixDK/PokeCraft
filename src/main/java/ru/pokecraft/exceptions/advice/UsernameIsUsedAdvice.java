package ru.pokecraft.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.pokecraft.exceptions.UsernameIsUsedException;

@RestControllerAdvice
public class UsernameIsUsedAdvice {

    @ExceptionHandler(UsernameIsUsedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ResponseEntity<String> usernameIsUsedHandler(UsernameIsUsedException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
