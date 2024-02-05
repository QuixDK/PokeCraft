package ru.pokecraft.site.exceptions;
import static ru.pokecraft.site.constants.ExceptionMessages.usernameIsUsedExceptionMessage;

public class UsernameIsUsedException extends RuntimeException{
    public UsernameIsUsedException() {
        super(usernameIsUsedExceptionMessage);
    }
}
