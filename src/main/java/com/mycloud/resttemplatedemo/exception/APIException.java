package com.mycloud.resttemplatedemo.exception;/*
 *
 * @author Lawshiga
 *
 */

public class APIException extends RuntimeException{

    private static final long serialVersionUID = 2558889298285458134L;

    public APIException(String message){
        super(message);
    }
}
