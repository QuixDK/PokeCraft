package ru.pokecraft.site.exceptions;

public class NotEnoughMoneyOnBalanceException extends RuntimeException{
    public NotEnoughMoneyOnBalanceException(String message) {
        super(message);
    }
}
