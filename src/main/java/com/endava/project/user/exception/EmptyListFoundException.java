package com.endava.project.user.exception;

public class EmptyListFoundException extends RuntimeException{

    public EmptyListFoundException() {
        super();
    }

    public EmptyListFoundException(String message) {
        super(message);
    }

    public EmptyListFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyListFoundException(Throwable cause) {
        super(cause);
    }

    protected EmptyListFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
