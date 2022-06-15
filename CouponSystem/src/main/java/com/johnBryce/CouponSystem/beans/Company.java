package com.johnBryce.CouponSystem.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    @Singular
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    @JsonIgnore
    @ToString.Exclude
    private List<Coupon> coupons = new ArrayList<>();

}

