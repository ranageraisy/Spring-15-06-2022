package com.johnBryce.CouponSystem.controller;


import com.johnBryce.CouponSystem.beans.Category;
import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.beans.Customer;
import com.johnBryce.CouponSystem.clientType.ClientType;
import com.johnBryce.CouponSystem.dto.LoginDto;
import com.johnBryce.CouponSystem.exceptions.CustomException;
import com.johnBryce.CouponSystem.services.CustomerService;
import com.johnBryce.CouponSystem.services.LoginManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class CustomerController{

    final private CustomerService customerService;


    @PostMapping("coupon/{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void purchaseCoupon(@PathVariable int customerId, @RequestBody Coupon coupon) throws CustomException {
        customerService.purchaseCoupon(customerId, coupon);
    }


    @GetMapping("coupons/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCustomerCoupons(@PathVariable int customerId) {
        return customerService.getCustomerCoupons(customerId);
    }

    @GetMapping("coupons/category/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCustomerCoupons(@PathVariable int customerId, @RequestParam Category category) {
        return customerService.getCustomerCoupons(customerId, category);
    }

    @GetMapping("coupons/maxPrice/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCustomerCoupons(@PathVariable int customerId, @RequestParam double maxPrice) {
        return customerService.getCustomerCoupons(customerId, maxPrice);
    }

    @GetMapping("details/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerDetails(@PathVariable int customerId) throws CustomException {
        return customerService.getCustomerDetails(customerId);
    }

}
