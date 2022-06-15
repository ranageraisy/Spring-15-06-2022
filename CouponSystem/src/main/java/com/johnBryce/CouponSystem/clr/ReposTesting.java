package com.johnBryce.CouponSystem.clr;

import com.johnBryce.CouponSystem.beans.Category;
import com.johnBryce.CouponSystem.beans.Company;
import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.beans.Customer;
import com.johnBryce.CouponSystem.repos.CompanyRepo;
import com.johnBryce.CouponSystem.repos.CouponRepo;
import com.johnBryce.CouponSystem.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

//@Component
//@Order(1)
public class ReposTesting implements CommandLineRunner {

    @Autowired
    private CouponRepo couponRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void run(String... args) throws Exception {

        Coupon coupon1 = Coupon.builder()
                .category(Category.FOOD)
                .title("cocacola")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.of(2022, 3, 2)))
                .amount(10)
                .price(50)
                .build();

        Coupon coupon2 = Coupon.builder()
                .category(Category.FOOD)
                .title("cocacola*2")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.of(2022, 3, 2)))
                .amount(10)
                .price(50)
                .build();

        Coupon coupon3 = Coupon.builder()
                .category(Category.FOOD)
                .title("fanta")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.of(2022, 3, 2)))
                .amount(10)
                .price(50)
                .build();

        Company company1 = Company.builder()
                .name("cocacola")
                .email("coca@gmail.com")
                .password("123")
                .coupons(Arrays.asList(coupon1, coupon2))
                .build();

        Company company2 = Company.builder().name("fanta").email("fanta@gmail.com").password("123").coupon(coupon3).build();

        companyRepo.saveAll(Arrays.asList(company1, company2));

        Customer customer1 = Customer.builder()
                .first_name("rana")
                .last_name("geraisy")
                .email("rana@gmail.com")
                .password("123")
                .build();

        Customer customer2 = Customer.builder()
                .first_name("elias")
                .last_name("geraisy")
                .email("elias@gmail.com")
                .password("123")
                .build();

        Customer customer3 = Customer.builder()
                .first_name("nabela")
                .last_name("geraisy")
                .email("nabela@gmail.com")
                .password("123")
                .build();

        Customer customer4 = Customer.builder()
                .first_name("shaked")
                .last_name("benratzon")
                .email("shaked@gmail.com")
                .password("123")
                .build();

        customerRepo.saveAll(Arrays.asList(customer1, customer2, customer3, customer4));


    }
}
