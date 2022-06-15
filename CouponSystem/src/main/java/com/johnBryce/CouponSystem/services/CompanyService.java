package com.johnBryce.CouponSystem.services;

import com.johnBryce.CouponSystem.beans.Category;
import com.johnBryce.CouponSystem.beans.Company;
import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.exceptions.CustomException;

import java.util.List;

public interface CompanyService {

    Coupon addCoupon(int companyId,Coupon coupon) throws CustomException;

    Coupon updateCoupon(int couponId, Coupon coupon) throws CustomException;

    void deleteCoupon(int CouponId) throws CustomException;

    List<Coupon> getCompanyCoupons(int companyId);

    List<Coupon> getCompanyCoupons(int companyId,Category category);

    List<Coupon> getCompanyCoupons(int companyId,double maxPrice);

    Company getCompanyDetails(int companyId) throws CustomException;

}
