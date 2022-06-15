package com.johnBryce.CouponSystem.services;

import com.johnBryce.CouponSystem.beans.Company;
import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.beans.Customer;
import com.johnBryce.CouponSystem.exceptions.CustomException;

import java.util.List;

public interface AdminService {

    Company addCompany(Company company) throws CustomException;

    Company updateCompany(int companyId, Company company) throws CustomException;

    void deleteCompany(int companyId) throws CustomException;

    List<Company> getAllCompanies();

    Company getOneCompanyById(int companyId) throws CustomException;

    Customer addCustomer(Customer customer) throws CustomException;

    Customer updateCustomer(int customerID, Customer customer) throws CustomException;

    void deleteCustomer(int customerId) throws CustomException;

    List<Customer> getAllCustomers();

    Customer getOneCustomerById(int customerId) throws CustomException;

    List<Coupon> getAllCoupons();

    Company getOneCompanyByEmail(String email) throws CustomException;

    Customer getOneCustomerByEmail(String email) throws CustomException;
}
