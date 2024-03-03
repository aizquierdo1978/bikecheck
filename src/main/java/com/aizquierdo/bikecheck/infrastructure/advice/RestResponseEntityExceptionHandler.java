package com.aizquierdo.bikecheck.infrastructure.advice;

import com.aizquierdo.bikecheck.infrastructure.common.dto.ApiError;
import com.aizquierdo.bikecheck.infrastructure.exception.EntityNotFoundException;
import com.aizquierdo.bikecheck.infrastructure.exception.InvalidEntityException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Log LOG = LogFactory.getLog(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ApiError> handleEntityNotFoundException(Exception ex, WebRequest request) {
        LOG.error(ex.getMessage(), ex);
        ApiError apiError = new ApiError(ex.getMessage(), ((EntityNotFoundException) ex).getErrors());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidEntityException.class})
    public ResponseEntity<ApiError> handleInvalidEntityException(Exception ex, WebRequest request) {
        LOG.error(ex.getMessage(), ex);
        ApiError apiError = new ApiError(ex.getMessage(), ((InvalidEntityException) ex).getErrors());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiError> handleOtherExceptions(Exception ex, WebRequest request) {
        LOG.error(ex.getMessage(), ex);
        ApiError apiError = new ApiError(ex.getMessage());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
