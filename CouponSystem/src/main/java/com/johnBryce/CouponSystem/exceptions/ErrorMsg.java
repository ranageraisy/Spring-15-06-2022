package com.johnBryce.CouponSystem.exceptions;

public enum ErrorMsg {

    ID_NOT_FOUND("Id not found"),
    ID_ALREADY_EXISTS("Id already exists"),
    COMPANY_NAME_ALREADY_EXISTS("company name already exists"),
    COMPANY_EMAIL_ALREADY_EXISTS("company Email already exists"),
    COUPON_ALREADY_EXISTS("coupon already exists"),
    ERROR_LOGIN("email or password is incorrect"),
    ALREADY_BOUGHT("you can't buy coupon twice!!!"),
    OUT_OF_STOCK("out of stock"),
    EXPIRED("Expired"),
    COUPON_NOT_EXISTS("Coupon not exists"),
    ILLEGAL_DATE("start date must be before end date"),
    ILLEGAL_AMOUNT("amount cannot be less than 0"),
    ID_CANNOT_BE_UPDATE("sorry, you can't update the ID"),
    NAME_CANNOT_BE_UPDATE("sorry, you can't update the ID"),
    EMAIL_NOT_FOUND("email not found");


    private String msg;

    ErrorMsg(String msg) {

        this.msg = msg;
    }

    public String GetMsg() {
        return msg;
    }
}
