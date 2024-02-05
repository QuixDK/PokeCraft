package ru.pokecraft.site.exceptions;


import static ru.pokecraft.site.constants.ExceptionMessages.wrongAuthParamExceptionMessage;

public class WrongAuthParamException extends RuntimeException{
    public WrongAuthParamException() {
        super(wrongAuthParamExceptionMessage);
    }
}
