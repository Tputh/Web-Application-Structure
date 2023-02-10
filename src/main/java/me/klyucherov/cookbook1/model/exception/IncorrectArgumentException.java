package me.klyucherov.cookbook1.model.exception;

public class IncorrectArgumentException extends Throwable {
    private final String argument;

    public IncorrectArgumentException(String argument) {
        this.argument = argument;
    }

    public String getMessage() {
        return " нет параметра " + argument;
    }
}
