package com.johnBryce.CouponSystem.services;

import com.johnBryce.CouponSystem.beans.Category;
import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.beans.Customer;
import com.johnBryce.CouponSystem.exceptions.CustomException;
import com.johnBryce.CouponSystem.exceptions.CustomExceptionUtil;
import com.johnBryce.CouponSystem.exceptions.ErrorMsg;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp extends ClientFacade implements CustomerService {



    public boolean login(String email, String password) throws CustomException {

         return customerRepo.existsByEmailAndPassword(email, password);

    }


    @Override
    public void purchaseCoupon(int customerId,Coupon coupon) throws CustomException {

        Coupon co = null;
        Optional<Coupon> coop = couponRepo.findById(coupon.getId());

        Customer cu = customerRepo.getById(customerId);

        if (coop.isPresent()) {
            co = coop.get();
        } else {
            throw new CustomException(ErrorMsg.COUPON_NOT_EXISTS);
        }

        if (co.getAmount() <= 0) {

            throw new CustomException(ErrorMsg.OUT_OF_STOCK);
        }
        if (co.getEndDate().before(java.sql.Date.valueOf(LocalDate.now()))) {
            throw new CustomException(ErrorMsg.EXPIRED);
        }

        if (cu.getCoupons().contains(co)) {
            throw new CustomException(ErrorMsg.ALREADY_BOUGHT);
        }

        cu.getCoupons().add(co);
        co.setAmount(co.getAmount() - 1);
        customerRepo.saveAndFlush(cu);
        couponRepo.saveAndFlush(co);
    }

    @Override
    public List<Coupon> getCustomerCoupons(int customerId) {

        return customerRepo.getById(customerId).getCoupons();
    }

    @Override
    public List<Coupon> getCustomerCoupons(int customerId,Category category) {
        return customerRepo.getById(customerId).getCoupons().stream()
                .filter(coupon -> coupon.getCategory() == category).collect(Collectors.toList());
    }

    @Override
    public List<Coupon> getCustomerCoupons(int customerId,double maxPrice) {
        return customerRepo.getById(customerId).getCoupons().stream()
                .filter(coupon -> coupon.getPrice() <= maxPrice).collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerDetails(int customerId) throws CustomException {
        return customerRepo.findById(customerId).orElseThrow(CustomExceptionUtil::IdNotFound);
    }
}
