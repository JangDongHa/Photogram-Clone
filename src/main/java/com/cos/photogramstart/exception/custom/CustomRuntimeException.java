package com.cos.photogramstart.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class CustomRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String message;
    private Map<String, String> errorMap;
    private HttpStatus httpStatus;
    public CustomRuntimeException(String message, Map<String, String> errorMap, HttpStatus httpStatus){
        super(errorMap.values().toString());
        this.message = message;
        this.errorMap = errorMap;
        this.httpStatus = httpStatus;
    }

    public Map<String, String> getErrorMap(){
        return errorMap;
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }

    public String getMessage(){
        return message;
    }
}
