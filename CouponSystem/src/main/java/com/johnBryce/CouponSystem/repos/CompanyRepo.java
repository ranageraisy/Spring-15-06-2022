package com.johnBryce.CouponSystem.repos;

import com.johnBryce.CouponSystem.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepo extends JpaRepository<Company, Integer> {

    Company findByEmail(String email);

    boolean existsByName(String name);

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

}
