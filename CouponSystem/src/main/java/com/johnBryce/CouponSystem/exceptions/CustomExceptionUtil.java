package com.johnBryce.CouponSystem.exceptions;

public class CustomExceptionUtil {


    public static CustomException IdNotFound() {
        return new CustomException(ErrorMsg.ID_NOT_FOUND);
    }

    public static CustomException EmailNotFound() {
        return new CustomException(ErrorMsg.EMAIL_NOT_FOUND);
    }




}
