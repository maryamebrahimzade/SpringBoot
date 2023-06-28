package ir.mapsa.secondspring.services;

import ir.mapsa.secondspring.exceptions.ServiceException;

public class EntityNotFound extends ServiceException {
    public EntityNotFound(String errorCode) {
        super(errorCode);
    }

    public EntityNotFound(String message, String errorCode) {
        super(message, errorCode);
    }

    public EntityNotFound(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }

    public EntityNotFound(Throwable cause, String errorCode) {
        super(cause, errorCode);
    }

    public EntityNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode);
    }
}
