package com.hb.business_case_backend.exception;

public class CantOpenConnectionException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CantOpenConnectionException() {
        super("Cannot Open Database Connection.");
    }

}
