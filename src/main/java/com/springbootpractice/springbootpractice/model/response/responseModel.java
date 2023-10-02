package com.springbootpractice.springbootpractice.model.response;

import lombok.*;

@Data
@Builder
public class responseModel<T> {

    private T data;
    private String message;
    private String status;
    
}
