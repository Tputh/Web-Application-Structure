package me.klyucherov.cookbook1.model.exception;

public class ValidationException extends RuntimeException {
    private final String entity;

    public ValidationException(String entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return " Ошибка валидации сущности " + entity;
    }
}
