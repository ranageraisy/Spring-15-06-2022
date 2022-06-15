package com.johnBryce.CouponSystem.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "coupons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "companyId", referencedColumnName = "id")
    @JsonIgnore
    @ToString.Exclude
    private Company company;

    @Enumerated(EnumType.STRING)
    private Category category;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private Integer amount;
    private double price;
    private String image;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REFRESH})
    @JoinTable(name = "customers_coupons", joinColumns = {
            @JoinColumn(name = "couponId")}, inverseJoinColumns = {@JoinColumn(name = "customerId")
    })
    @JsonIgnore
    @ToString.Exclude
    private List<Customer> customerList;
}
