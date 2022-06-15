package com.johnBryce.CouponSystem.services;

import com.johnBryce.CouponSystem.beans.Category;
import com.johnBryce.CouponSystem.beans.Company;
import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.exceptions.CustomException;
import com.johnBryce.CouponSystem.exceptions.CustomExceptionUtil;
import com.johnBryce.CouponSystem.exceptions.ErrorMsg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImp extends ClientFacade implements CompanyService {


    public boolean login(String email, String password) {

         return companyRepo.existsByEmailAndPassword(email, password);

    }

    @Override
    public Coupon addCoupon(int companyId,Coupon coupon) throws CustomException {

        if (couponRepo.existsById(coupon.getId()) && !(couponRepo.findByTitle(coupon.getTitle()).isEmpty())) {
            throw new CustomException(ErrorMsg.COUPON_ALREADY_EXISTS);
        }

        if (coupon.getEndDate().before(coupon.getStartDate())) {
            throw new CustomException(ErrorMsg.ILLEGAL_DATE);
        }

        if (coupon.getAmount() <= 0) {
            throw new CustomException(ErrorMsg.ILLEGAL_AMOUNT);
        }

        coupon.setCompany(getCompanyDetails(companyId));
        couponRepo.save(coupon);
        return coupon;
    }

    @Override
    public Coupon updateCoupon(int couponId, Coupon coupon) throws CustomException {

        if (!couponRepo.existsById(couponId)) {
            throw new CustomException(ErrorMsg.ID_NOT_FOUND);
        }
        if (couponId != coupon.getId()) {
            throw new CustomException(ErrorMsg.ID_CANNOT_BE_UPDATE);
        }

        if (!(couponRepo.getById(couponId).getTitle().equals(coupon.getTitle()))) {
            throw new CustomException(ErrorMsg.NAME_CANNOT_BE_UPDATE);
        }
        couponRepo.saveAndFlush(coupon);
        return coupon;
    }

    @Override
    public void deleteCoupon(int couponId) throws CustomException {

        if (!couponRepo.existsById(couponId)) {
            throw new CustomException(ErrorMsg.ID_NOT_FOUND);
        }
        couponRepo.deleteById(couponId);

    }

    @Override
    public List<Coupon> getCompanyCoupons(int companyId) {

        return couponRepo.findByCompanyId(companyId);
    }

    @Override
    public List<Coupon> getCompanyCoupons(int companyId,Category category) {

        return couponRepo.findByCompanyIdAndCategory(companyId, category);
    }

    @Override
    public List<Coupon> getCompanyCoupons(int companyId,double maxPrice) {
        return couponRepo.findByCompanyIdAndPriceLessThan(companyId, maxPrice);
    }

    @Override
    public Company getCompanyDetails(int companyId) throws CustomException {

        return companyRepo.findById(companyId).orElseThrow(CustomExceptionUtil::IdNotFound);
    }
}
