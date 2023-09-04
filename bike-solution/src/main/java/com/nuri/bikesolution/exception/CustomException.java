package com.nuri.bikesolution.exception;

public class CustomException extends Exception {

    private  String message;
    public CustomException(String message) {
        super(message);
    }
}
