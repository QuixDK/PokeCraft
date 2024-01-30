package ru.pokecraft.exceptions;

public class UserDataNotFoundException extends RuntimeException{
    public UserDataNotFoundException(String message) {
        super(message);
    }
}
