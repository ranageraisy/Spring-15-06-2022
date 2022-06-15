package com.johnBryce.CouponSystem.exceptions;

import java.util.function.Supplier;

public class CustomException extends Exception {


    public CustomException(ErrorMsg message) {
        super(message.GetMsg());
    }
}
