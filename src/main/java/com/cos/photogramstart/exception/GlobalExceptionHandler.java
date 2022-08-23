package com.cos.photogramstart.exception;


import com.cos.photogramstart.exception.custom.CustomRuntimeException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.auth.ResponseErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> proceedAllException(Exception e){
        return new ResponseEntity<>(String.format("<h1>%s</h1>", e.getMessage()), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(CustomRuntimeException.class)
    public String runtimeException(CustomRuntimeException e){
        return Script.back(e.getErrorMap().values().toString());
        //return new ResponseEntity<>(new ResponseErrorDto<>(-1, e.getMessage(), e.getErrorMap()), e.getHttpStatus());
    }
}
