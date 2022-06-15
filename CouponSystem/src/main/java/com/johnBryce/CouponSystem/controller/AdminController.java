package com.johnBryce.CouponSystem.controller;

import com.johnBryce.CouponSystem.beans.Company;
import com.johnBryce.CouponSystem.beans.Customer;
import com.johnBryce.CouponSystem.dto.LoginDto;
import com.johnBryce.CouponSystem.exceptions.CustomException;
import com.johnBryce.CouponSystem.services.AdminService;
import com.johnBryce.CouponSystem.services.AdminServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;


    @PostMapping("company")
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company) throws CustomException {
        return adminService.addCompany(company);
    }

    @PutMapping("company")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Company updateCompany(@PathVariable int id, @RequestBody Company company) throws CustomException {
        return adminService.updateCompany(id, company);
    }

    @DeleteMapping("company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int id) throws CustomException {
        adminService.deleteCompany(id);
    }

    @GetMapping("companies")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }

    @GetMapping("company/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company getOneCompanyById(@PathVariable int id) throws CustomException {
        return adminService.getOneCompanyById(id);
    }

    @PostMapping("customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) throws CustomException {
        return adminService.addCustomer(customer);
    }

    @PutMapping("customer")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) throws CustomException {
        return adminService.updateCustomer(id, customer);
    }

    @DeleteMapping("customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) throws CustomException {
        adminService.deleteCustomer(id);
    }

    @GetMapping("customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    @GetMapping("customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getOneCustomerById(@PathVariable int id) throws CustomException {
        return adminService.getOneCustomerById(id);
    }

}
