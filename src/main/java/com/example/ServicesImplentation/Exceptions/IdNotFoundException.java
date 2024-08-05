package com.example.ServicesImplentation.Exceptions;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String message){
        super(message);
    }
}
