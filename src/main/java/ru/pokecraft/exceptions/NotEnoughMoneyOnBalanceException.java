package ru.pokecraft.exceptions;

public class NotEnoughMoneyOnBalanceException extends RuntimeException{
    public NotEnoughMoneyOnBalanceException(String message) {
        super(message);
    }
}
