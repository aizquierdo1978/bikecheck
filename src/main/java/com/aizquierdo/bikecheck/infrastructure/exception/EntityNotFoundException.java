package com.aizquierdo.bikecheck.infrastructure.exception;

import java.io.Serial;
import java.util.List;

public class EntityNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -8936524959525876789L;

    private List<String> errors;


    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public EntityNotFoundException(List<String> errors) {
        super();
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

}
