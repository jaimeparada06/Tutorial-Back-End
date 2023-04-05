package com.ccsw.tutorial.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class AlreadyExistsException extends Exception {
    public AlreadyExistsException(String str) {
        // calling the constructor of parent Exception
        super(str);
    }

}
