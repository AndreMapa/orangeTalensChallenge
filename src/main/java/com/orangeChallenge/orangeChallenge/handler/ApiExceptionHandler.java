package com.orangeChallenge.orangeChallenge.handler;

import com.orangeChallenge.orangeChallenge.models.Error;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<Error.Field> fields = new ArrayList<>();

        for (ObjectError error : exception.getBindingResult().getAllErrors()){
            String name = ((FieldError) error).getField();
            String msg = error.getDefaultMessage();
            fields.add(new Error.Field(name,msg));
        }

        Error error = new Error("Pay attention! Invalid Fields", status.value(), fields);
        return super.handleExceptionInternal(exception,error,headers,status,request);
    }
}
