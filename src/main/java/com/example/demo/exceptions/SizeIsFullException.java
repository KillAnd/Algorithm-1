package com.example.demo.exceptions;

public class SizeIsFullException extends RuntimeException {
    public SizeIsFullException(String message) {
        super(message);
    }
}
