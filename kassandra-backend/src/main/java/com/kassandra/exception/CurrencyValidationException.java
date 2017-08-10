package com.kassandra.exception;

import javax.validation.ValidationException;

/**
 * @author Onur Karaduman
 * @since 08.06.17
 */
public class CurrencyValidationException extends ValidationException {
    public CurrencyValidationException(String message, Throwable t) {
        super(message, t);
    }

    public CurrencyValidationException() {
        super();
    }

}