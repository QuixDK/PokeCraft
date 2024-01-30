package ru.pokecraft.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.pokecraft.exceptions.WrongAuthParamException;

@RestControllerAdvice
public class WrongAuthPararmAdvice {

    @ExceptionHandler(WrongAuthParamException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> wrongAuthParamExceptionHandler(WrongAuthParamException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
