package com.springbootpractice.springbootpractice.model.response;

import java.io.Serializable;

import lombok.*;

@Data
public class ResponseModel<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T data;
    private String message;
    private ResponseStatus status;

    public static enum ResponseStatus { SUCCESS, FAILED, ERROR }

    public ResponseModel() {}

    public ResponseModel(T data) {
        this.data = data;
    }

    public ResponseModel(String message) {
        this.message = message;
    }

    public ResponseModel(ResponseStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseModel(T data, ResponseStatus status) {
        this.data = data;
        this.status = status;
    }
    
}
