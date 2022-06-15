package com.johnBryce.CouponSystem.clr;


import com.johnBryce.CouponSystem.beans.Category;
import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.clientType.ClientType;
import com.johnBryce.CouponSystem.services.CompanyService;
import com.johnBryce.CouponSystem.services.LoginManager;
import com.johnBryce.CouponSystem.utils.Art;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(2)
public class CompanyServiceTesting implements CommandLineRunner {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private LoginManager loginManager;


    Coupon coupon1 = Coupon.builder()
            .category(Category.FOOD)
            .title("fanta")
            .startDate(Date.valueOf(LocalDate.now()))
            .endDate(Date.valueOf(LocalDate.of(2022, 7, 2)))
            .amount(10)
            .price(50)
            .build();

    Coupon coupon2 = Coupon.builder()
            .category(Category.FOOD)
            .title("tnova")
            .startDate(Date.valueOf(LocalDate.now()))
            .endDate(Date.valueOf(LocalDate.of(2022, 7, 2)))
            .amount(10)
            .price(50)
            .build();

    Coupon coupon3 = Coupon.builder()
            .category(Category.FOOD)
            .title("tnova1")
            .startDate(Date.valueOf(LocalDate.now()))
            .endDate(Date.valueOf(LocalDate.of(2022, 7, 2)))
            .amount(10)
            .price(50)
            .build();


    @Override
    public void run(String... args) throws Exception {

        System.out.println(Art.companyServiceTesting);

        companyService.addCoupon(1, coupon1);

        try {
            companyService.addCoupon(1, coupon1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        companyService.addCoupon(1, coupon2);
        companyService.addCoupon(1, coupon3);
        System.out.println();
        System.out.println("******Update Coupon******\n");

        System.out.println(coupon2.toString());
        coupon2.setAmount(1000);
        System.out.println(coupon2.toString());
        System.out.println();
        System.out.println("******Delete Coupon******\n");

        companyService.getCompanyCoupons(1).forEach(System.out::println);

        companyService.deleteCoupon(coupon2.getId());
        System.out.println("**************************\n");

        companyService.getCompanyCoupons(1).forEach(System.out::println);
        System.out.println("**************************\n");

        companyService.getCompanyCoupons(1,50).forEach(System.out::println);
        System.out.println("**************************\n");

        companyService.getCompanyCoupons(1, Category.FOOD).forEach(System.out::println);
    }
}
