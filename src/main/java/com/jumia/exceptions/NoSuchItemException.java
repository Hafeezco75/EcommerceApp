package com.jumia.exceptions;


public class NoSuchItemException extends RuntimeException {

    public NoSuchItemException(String message) {
        super(message);
    }
}
