package com.johnBryce.CouponSystem.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;

    @Singular
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinTable(name = "customers_coupons", joinColumns = {
            @JoinColumn(name = "customerId")}, inverseJoinColumns = {@JoinColumn(name = "couponId")
    })
    @JsonIgnore
    @ToString.Exclude
    private List<Coupon> coupons = new ArrayList<>();

}
