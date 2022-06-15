package com.johnBryce.CouponSystem.controller;


import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.beans.Customer;
import com.johnBryce.CouponSystem.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class PublicController {

    private final AdminService adminService;

    @GetMapping("coupons")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getAllCoupons() {
        return adminService.getAllCoupons();
    }


}
