package com.endava.project.doctor.exception;

public class DoctorsListEmptyException extends RuntimeException {
    public DoctorsListEmptyException() {
        super();
    }

    public DoctorsListEmptyException(String message) {
        super(message);
    }

    public DoctorsListEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorsListEmptyException(Throwable cause) {
        super(cause);
    }

    protected DoctorsListEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
