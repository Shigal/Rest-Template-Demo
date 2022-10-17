package com.mycloud.resttemplatedemo.exception;/*
 *
 * @author Lawshiga
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 2020270937349504088L;

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
