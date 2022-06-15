package com.johnBryce.CouponSystem.clr;

import com.johnBryce.CouponSystem.beans.Category;
import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.clientType.ClientType;
import com.johnBryce.CouponSystem.repos.CouponRepo;
import com.johnBryce.CouponSystem.services.CustomerService;
import com.johnBryce.CouponSystem.services.LoginManager;
import com.johnBryce.CouponSystem.utils.Art;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class CustomerServiceTesting implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CouponRepo couponRepo;

    @Autowired
    private LoginManager loginManager;


    @Override
    public void run(String... args) throws Exception {

        System.out.println(Art.customerServiceTesting);

        Coupon coupon1 = couponRepo.getById(1);
        Coupon coupon2 = couponRepo.getById(2);
        Coupon coupon3 = couponRepo.getById(3);

        try {
            customerService.purchaseCoupon(1,coupon1);
            customerService.purchaseCoupon(1,coupon3);
            customerService.purchaseCoupon(1,coupon2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("**************************\n");
        System.out.println("");

        customerService.getCustomerCoupons(1).forEach(System.out::println);
        System.out.println("");

        System.out.println("**************************\n");

        customerService.getCustomerCoupons(1,Category.FOOD).forEach(System.out::println);
        System.out.println("");

        System.out.println("**************************\n");

        customerService.getCustomerCoupons(1,1000.0).forEach(System.out::println);


    }
}
