package com.endava.project.doctor.exception;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException() {
        super();
    }

    public DoctorNotFoundException(String message) {
        super(message);
    }

    public DoctorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DoctorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
