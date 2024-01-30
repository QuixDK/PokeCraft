package ru.pokecraft.exceptions;
import static ru.pokecraft.constants.ExceptionMessages.usernameIsUsedExceptionMessage;

public class UsernameIsUsedException extends RuntimeException{
    public UsernameIsUsedException() {
        super(usernameIsUsedExceptionMessage);
    }
}
