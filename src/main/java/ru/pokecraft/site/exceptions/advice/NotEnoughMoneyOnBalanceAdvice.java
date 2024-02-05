package ru.pokecraft.site.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.pokecraft.site.exceptions.NotEnoughMoneyOnBalanceException;

@RestControllerAdvice
public class NotEnoughMoneyOnBalanceAdvice {
    @ExceptionHandler(NotEnoughMoneyOnBalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> notEnoughMoneyOnBalanceExceptionHandler(NotEnoughMoneyOnBalanceException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
