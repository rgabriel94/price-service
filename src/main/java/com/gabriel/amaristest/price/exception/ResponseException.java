package com.gabriel.amaristest.price.exception;

import com.gabriel.amaristest.price.model.dto.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseException extends RuntimeException {

    protected final HttpStatus httpStatus;
    protected final String response;

    public ResponseException(HttpStatus httpStatus, String response) {
        super(response);
        this.httpStatus = httpStatus;
        this.response = response;
    }

    public ResponseEntity<ErrorResponse> getResponse() {
        ErrorResponse errorResponse = ErrorResponse.builder().message(response).build();
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }
}
