package com.acciojob.CricBuzz.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
