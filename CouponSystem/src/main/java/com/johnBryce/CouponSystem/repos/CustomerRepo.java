package com.johnBryce.CouponSystem.repos;

import com.johnBryce.CouponSystem.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<Customer, Integer> {


    boolean existsByEmailAndPassword(String email, String password);

    Customer findByEmail(String email);
}
