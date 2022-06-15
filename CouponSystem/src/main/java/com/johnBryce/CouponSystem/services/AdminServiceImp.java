package com.johnBryce.CouponSystem.services;

import com.johnBryce.CouponSystem.beans.Company;
import com.johnBryce.CouponSystem.beans.Coupon;
import com.johnBryce.CouponSystem.beans.Customer;
import com.johnBryce.CouponSystem.exceptions.CustomException;
import com.johnBryce.CouponSystem.exceptions.CustomExceptionUtil;
import com.johnBryce.CouponSystem.exceptions.ErrorMsg;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImp extends ClientFacade implements AdminService {

    public boolean login(String email, String password) {

        return (email.equalsIgnoreCase("Admin@admin.com") && password.equals("Admin"));
    }

    @Override
    public Company addCompany(Company company) throws CustomException {

        if (companyRepo.existsById(company.getId())) {
            throw new CustomException(ErrorMsg.ID_ALREADY_EXISTS);
        }
        if (companyRepo.existsByName(company.getName())) {
            throw new CustomException(ErrorMsg.COMPANY_NAME_ALREADY_EXISTS);
        }
        if (companyRepo.existsByEmail(company.getEmail())) {
            throw new CustomException(ErrorMsg.COMPANY_EMAIL_ALREADY_EXISTS);
        }

        companyRepo.save(company);
        return company;
    }

    @Override
    public Company updateCompany(int companyId, Company company) throws CustomException {


        if (!companyRepo.existsById(companyId)) {
            throw new CustomException(ErrorMsg.ID_NOT_FOUND);
        }

        if (companyId != company.getId()) {
            throw new CustomException(ErrorMsg.ID_CANNOT_BE_UPDATE);
        }

        if (!(companyRepo.getById(companyId).getName().equals(company.getName()))) {
            throw new CustomException(ErrorMsg.NAME_CANNOT_BE_UPDATE);
        }

        companyRepo.saveAndFlush(company);
        return company;
    }

    @Override
    public void deleteCompany(int companyId) throws CustomException {
        if (!companyRepo.existsById(companyId)) {
            throw new CustomException(ErrorMsg.ID_NOT_FOUND);
        }
        companyRepo.deleteById(companyId);

    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public Company getOneCompanyById(int companyId) throws CustomException {
        return companyRepo.findById(companyId).orElseThrow(CustomExceptionUtil::IdNotFound);
    }

    @Override
    public Customer addCustomer(Customer customer) throws CustomException {

        if (customerRepo.existsById(customer.getId())) {
            throw new CustomException(ErrorMsg.ID_ALREADY_EXISTS);
        }
        customerRepo.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(int customerID, Customer customer) throws CustomException {

        if (!customerRepo.existsById(customerID)) {
            throw new CustomException(ErrorMsg.ID_NOT_FOUND);
        }
        customerRepo.saveAndFlush(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(int customerId) throws CustomException {

        if (!customerRepo.existsById(customerId)) {
            throw new CustomException(ErrorMsg.ID_NOT_FOUND);
        }
        customerRepo.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepo.findAll();
    }

    @Override
    public Customer getOneCustomerById(int customerId) throws CustomException {

        return customerRepo.findById(customerId).orElseThrow(CustomExceptionUtil::IdNotFound);
    }

    @Override
    public List<Coupon> getAllCoupons() {

        return couponRepo.findAll();
    }

    @Override
    public Company getOneCompanyByEmail(String email) throws CustomException {
        return companyRepo.findByEmail(email);
    }

    @Override
    public Customer getOneCustomerByEmail(String email) throws CustomException {

        return customerRepo.findByEmail(email);
    }

}
