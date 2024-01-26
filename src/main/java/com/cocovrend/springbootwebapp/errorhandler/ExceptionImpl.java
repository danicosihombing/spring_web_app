package com.cocovrend.springbootwebapp.errorhandler;

public class ExceptionImpl extends RuntimeException{
    public ExceptionImpl(String message) {
        super(message);
    }
}
