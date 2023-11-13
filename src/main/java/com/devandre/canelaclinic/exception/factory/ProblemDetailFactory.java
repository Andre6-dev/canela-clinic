package com.devandre.canelaclinic.exception.factory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.time.Instant;

/**
 * andre on 13/11/2023
 */
@Component
public class ProblemDetailFactory {

    public ProblemDetail createProblemDetail(HttpStatus status, String detail, String title, URI type, String errorCategory) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, detail);
        problemDetail.setTitle(title);
        problemDetail.setType(type);
        problemDetail.setProperty("errorCategory", errorCategory);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
