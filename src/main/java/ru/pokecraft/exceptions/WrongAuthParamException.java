package ru.pokecraft.exceptions;


import static ru.pokecraft.constants.ExceptionMessages.wrongAuthParamExceptionMessage;

public class WrongAuthParamException extends RuntimeException{
    public WrongAuthParamException() {
        super(wrongAuthParamExceptionMessage);
    }
}
