package com.endava.project.doctor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Doctor not found.")
public class DoctorNotFoundRestException extends RuntimeException{
    public DoctorNotFoundRestException() {
        super();
    }

    public DoctorNotFoundRestException(String message) {
        super(message);
    }

    public DoctorNotFoundRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorNotFoundRestException(Throwable cause) {
        super(cause);
    }

    protected DoctorNotFoundRestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
