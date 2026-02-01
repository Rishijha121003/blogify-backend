package com.blogify.blog_service.exception;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(String messsage){
        super(messsage);
    }
}
