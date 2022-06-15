package com.johnBryce.CouponSystem.advice;


import com.johnBryce.CouponSystem.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = {CustomException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDto handleErrors(Exception e){
        return new ErrDto("ERROR!!!!!!!",e.getMessage());
    }
}

