package com.onetomany.exception;

public class CustomerNotFound extends Exception {
    public CustomerNotFound(final String message) {
        super(message);
    }
}
