package com.gabriel.amaristest.price.controller;

import com.gabriel.amaristest.price.exception.ResponseException;
import com.gabriel.amaristest.price.interfaces.ModelMapperService;
import com.gabriel.amaristest.price.model.dto.error.ErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
public class BaseController {

    @Autowired
    @Qualifier(value = "ModelMapperServiceImpl")
    protected ModelMapperService mapper;

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(ResponseException responseException) {
        log.warn(responseException);
        return responseException.getResponse();
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.error(exception);
        ResponseException responseException = new ResponseException(HttpStatus.BAD_REQUEST, exception.getMessage());
        return responseException.getResponse();
    }
}
