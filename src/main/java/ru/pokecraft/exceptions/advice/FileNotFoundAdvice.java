package ru.pokecraft.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.pokecraft.exceptions.FileNotFoundException;

@RestControllerAdvice
public class FileNotFoundAdvice {

    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleFileNotFoundException(FileNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
