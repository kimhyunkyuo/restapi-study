package com.example.restapi.exception;

public class UserException extends RuntimeException{
    private ErrorCode errorCode;

    public UserException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
