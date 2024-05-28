package com.oliveiradev.course.workshopmongo.services.exception;

public class ObjectNoFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNoFoundException(String msg) {
        super(msg);
    }
}
