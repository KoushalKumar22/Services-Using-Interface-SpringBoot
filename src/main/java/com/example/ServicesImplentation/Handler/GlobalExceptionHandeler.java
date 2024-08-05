package com.example.ServicesImplentation.Handler;

import com.example.ServicesImplentation.Exceptions.IdNotFoundException;
import com.example.ServicesImplentation.Exceptions.NameNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandeler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> ValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName=((FieldError)error).getField();
            String errorMessage=error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<Object> handleNameNotFoundException(NameNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
}
