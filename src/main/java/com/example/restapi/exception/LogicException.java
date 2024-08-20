package com.example.restapi.exception;

import lombok.Getter;

@Getter
public class LogicException extends RuntimeException{

    private ErrorCode errorCode;

    public LogicException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}