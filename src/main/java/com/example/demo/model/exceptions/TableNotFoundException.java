package com.example.demo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TableNotFoundException extends RuntimeException{
    
    public TableNotFoundException(Long number) {
        super(String.format("Table with number: %d was not found", number));
    }


}
