package com.johnBryce.CouponSystem.services;

import com.johnBryce.CouponSystem.exceptions.CustomException;
import com.johnBryce.CouponSystem.repos.CompanyRepo;
import com.johnBryce.CouponSystem.repos.CouponRepo;
import com.johnBryce.CouponSystem.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class ClientFacade {

    @Autowired
    protected CouponRepo couponRepo;

    @Autowired
    protected CompanyRepo companyRepo;

    @Autowired
    protected CustomerRepo customerRepo;

    public abstract boolean login(String email, String password) throws CustomException;

}
