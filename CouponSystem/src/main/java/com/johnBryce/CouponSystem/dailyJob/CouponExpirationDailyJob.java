package com.johnBryce.CouponSystem.dailyJob;

import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.repos.CouponRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class CouponExpirationDailyJob {

    @Getter
    private boolean quit = false;

    @Autowired
    private CouponRepo couponRepo;

    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    public void CouponExpirationDailyJob() {
        if (!quit) {
            try {
                List<Coupon> coupons = couponRepo.findByEndDateBefore(Date.valueOf(LocalDate.now()));
                if (!coupons.isEmpty()) {
                    System.out.println("********** Expired coupons **********");
                    for (Coupon coupon : coupons) {
                        System.out.println(coupon);
                        couponRepo.delete(coupon);
                        Thread.sleep(1000 * 10);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        quit = true;
    }
}
