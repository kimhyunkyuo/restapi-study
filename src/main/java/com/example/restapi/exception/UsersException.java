package com.example.restapi.exception;

public class UsersException extends RuntimeException{
    private ErrorCode errorCode;

    public UsersException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
