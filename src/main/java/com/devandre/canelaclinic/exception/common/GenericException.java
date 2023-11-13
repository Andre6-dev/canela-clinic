package com.devandre.canelaclinic.exception.common;

import java.io.Serial;

/**
 * andre on 13/11/2023
 */
public class GenericException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public GenericException(String message) {
        super(message);
    }
}
