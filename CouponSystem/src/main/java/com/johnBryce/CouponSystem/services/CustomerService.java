package com.johnBryce.CouponSystem.services;

import com.johnBryce.CouponSystem.beans.Category;
import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.beans.Customer;
import com.johnBryce.CouponSystem.exceptions.CustomException;

import java.util.List;

public interface CustomerService {

    public void purchaseCoupon(int customerId,Coupon coupon) throws CustomException;

    public List<Coupon> getCustomerCoupons(int customerId);

    public List<Coupon> getCustomerCoupons(int customerId,Category category);

    public List<Coupon> getCustomerCoupons(int customerId,double maxPrice);

    public Customer getCustomerDetails(int customerId) throws CustomException;


}
