package com.devandre.canelaclinic.exception;

import com.devandre.canelaclinic.exception.common.DuplicateResourceException;
import com.devandre.canelaclinic.exception.common.GenericException;
import com.devandre.canelaclinic.exception.common.RequestValidationException;
import com.devandre.canelaclinic.exception.common.ResourceNotFoundException;
import com.devandre.canelaclinic.exception.factory.ProblemDetailFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

import static com.devandre.canelaclinic.utiils.Constants.Exception.Common.*;

/**
 * andre on 13/11/2023
 */
@Slf4j(topic = "GlobalExceptionHandler")
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final ProblemDetailFactory prob;

    public GlobalExceptionHandler(ProblemDetailFactory prob) {
        this.prob = prob;
    }

    @ExceptionHandler(value = {ServerErrorException.class})
    public ProblemDetail serverErrorException(ServerErrorException ex) {
        log.error("ServerErrorException: {}", ex.getMessage());
        return prob.createProblemDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                SERVER_ERROR,
                URI.create(URI_SERVER_ERROR_MESSAGE),
                ERROR_CATEGORY
        );
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ProblemDetail resourceNotFoundException(ResourceNotFoundException ex) {
        log.error("ResourceNotFoundException: {}", ex.getMessage());
        return prob.createProblemDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                RESOURCE_NOT_FOUND,
                URI.create(URI_NOT_FOUND_MESSAGE),
                ERROR_CATEGORY
        );
    }

    @ExceptionHandler(value = {DuplicateResourceException.class})
    public ProblemDetail duplicateResourceException(DuplicateResourceException ex) {
        log.error("DuplicateResourceException: {}", ex.getMessage());
        return prob.createProblemDetail(
                HttpStatus.CONFLICT,
                ex.getMessage(),
                DUPLICATE_RESOURCE,
                URI.create(URI_DUPLICATE_RESOURCE_MESSAGE),
                ERROR_CATEGORY
        );
    }

    @ExceptionHandler(value = {RequestValidationException.class})
    public ProblemDetail requestValidationException(RequestValidationException ex) {
        log.error("RequestValidationException: {}", ex.getMessage());
        return prob.createProblemDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                REQUEST_VALIDATION_ERROR,
                URI.create(URI_REQUEST_VALIDATION_ERROR_MESSAGE),
                ERROR_CATEGORY
        );
    }

    @ExceptionHandler(value = {GenericException.class})
    public ProblemDetail genericException(GenericException ex) {
        log.error("GenericException: {}", ex.getMessage());
        return prob.createProblemDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                GENERIC_ERROR,
                URI.create(URI_GENERIC_ERROR_MESSAGE),
                ERROR_CATEGORY
        );
    }
}
