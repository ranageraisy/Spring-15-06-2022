package com.johnBryce.CouponSystem.repos;

import com.johnBryce.CouponSystem.beans.Category;
import com.johnBryce.CouponSystem.beans.Company;
import com.johnBryce.CouponSystem.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


public interface CouponRepo extends JpaRepository<Coupon, Integer> {

    List<Coupon> findByTitle(String title);

    List<Coupon> findByCompanyId(int companyId);

    List<Coupon> findByCompanyIdAndCategory(int companyId, Category category);

    List<Coupon> findByCompanyIdAndPriceLessThan(int companyId, double maxPrice);

    List<Coupon> findByEndDateBefore(Date date);
}
