package com.gabriel.amaristest.price.interfaces;

import com.gabriel.amaristest.price.exception.ResponseException;
import org.springframework.validation.BindingResult;

public interface BindingResultService {

    void bindingResultErrors(BindingResult bindingResult) throws ResponseException;
}
