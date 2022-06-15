package com.johnBryce.CouponSystem.controller;


import com.johnBryce.CouponSystem.beans.Category;
import com.johnBryce.CouponSystem.beans.Company;
import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.exceptions.CustomException;
import com.johnBryce.CouponSystem.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/company/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class CompanyController {


    final private CompanyService companyService;


    @PostMapping("{companyId}/coupon")
    @ResponseStatus(HttpStatus.CREATED)
    public Coupon addCoupon(@PathVariable int companyId, @RequestBody Coupon coupon) throws CustomException {
        return companyService.addCoupon(companyId, coupon);
    }


    @PutMapping("coupon")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Coupon updateCoupon(@PathVariable int id, @RequestBody Coupon coupon) throws CustomException {
        return companyService.updateCoupon(id, coupon);
    }

    @DeleteMapping("coupon/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@PathVariable int id) throws CustomException {
        companyService.deleteCoupon(id);
    }

    @GetMapping("coupons/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCompanyCoupons(@PathVariable int companyId) {
        return companyService.getCompanyCoupons(companyId);
    }

    @GetMapping("coupons/category/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCompanyCoupons(@PathVariable int companyId, @RequestParam Category category) {
        return companyService.getCompanyCoupons(companyId, category);
    }


    @GetMapping("coupons/maxPrice/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCompanyCoupons(@PathVariable int companyId, @RequestParam double maxPrice) {
        return companyService.getCompanyCoupons(companyId, maxPrice);
    }


    @GetMapping("details/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public Company getCompanyDetails(@PathVariable int companyId) throws CustomException {
        return companyService.getCompanyDetails(companyId);
    }

}
