package com.acciojob.CricBuzz.exception;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(String message) {
        super(message);
    }
}
