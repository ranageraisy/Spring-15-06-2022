package com.johnBryce.CouponSystem.clientType;

public enum ClientType {
    ADMINISTRATOR, COMPANY, CUSTOMER;

    private static ClientType[] clinClientTypes = {ADMINISTRATOR, COMPANY, CUSTOMER};

    public static ClientType[] geClientTypes() {
        return clinClientTypes;

    }
}
