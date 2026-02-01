package com.blogify.user_service.exception;

public class WrongPasswordException extends RuntimeException{

    public WrongPasswordException(String message){
        super(message);
    }
}
