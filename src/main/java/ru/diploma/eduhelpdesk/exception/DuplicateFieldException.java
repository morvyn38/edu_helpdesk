package ru.diploma.eduhelpdesk.exception;

import lombok.Getter;

@Getter
public class DuplicateFieldException extends RuntimeException {
    private final String filed;

    public DuplicateFieldException(String field, String message) {
        super(message);
        this.filed = field;
    }
}
