package com.aizquierdo.bikecheck.infrastructure.exception;

import java.io.Serial;
import java.util.List;

public class InvalidEntityException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 2082862875646043577L;

    private List<String> errors;

    public InvalidEntityException() {
        super();
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public InvalidEntityException(List<String> errors) {
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
