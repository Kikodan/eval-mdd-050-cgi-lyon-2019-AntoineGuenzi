package com.ipiecoles.java.eval.mdd050.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(EntityNotFoundException.class)
        @ResponseBody
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String handleEntityNotFoundException(EntityNotFoundException entityNotFoundException)
        {
            return entityNotFoundException.getMessage();
        }

        @ExceptionHandler(EntityExistsException.class)
        @ResponseBody
        @ResponseStatus(HttpStatus.CONFLICT)
        public String handleEntityExistsException(EntityExistsException entityExistsException)
        {
            return entityExistsException.getMessage();
        }
}

