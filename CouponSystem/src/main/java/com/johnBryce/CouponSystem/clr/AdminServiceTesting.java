package com.johnBryce.CouponSystem.clr;


import com.johnBryce.CouponSystem.beans.Company;
import com.johnBryce.CouponSystem.beans.Customer;
import com.johnBryce.CouponSystem.clientType.ClientType;
import com.johnBryce.CouponSystem.services.*;
import com.johnBryce.CouponSystem.utils.Art;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AdminServiceTesting implements CommandLineRunner {


    @Autowired
    private CompanyService companyService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private LoginManager loginManager;


    Company company1 = Company.builder()
            .name("tnova")
            .email("tnova@gmail.com")
            .password("123")
            .build();

    Company company2 = Company.builder()
            .name("fanta")
            .email("fanta@gmail.com")
            .password("123")
            .build();

    Company company3 = Company.builder()
            .name("scoop")
            .email("scoop@gmail.com")
            .password("123")
            .build();

    Customer customer1 = Customer.builder()
            .first_name("rana")
            .last_name("geraisy")
            .email("rana@gmail.com")
            .password("123")
            .build();

    Customer customer2 = Customer.builder()
            .first_name("elias")
            .last_name("geraisy")
            .email("elias@gmail.com")
            .password("123")
            .build();

    Customer customer3 = Customer.builder()
            .first_name("nabela")
            .last_name("geraisy")
            .email("nabela@gmail.com")
            .password("123")
            .build();

    @Override
    public void run(String... args) throws Exception {

        System.out.println(Art.adminServiceTesting);

        adminService.addCompany(company1);
        try {
            adminService.addCompany(company1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        adminService.addCompany(company2);
        adminService.addCompany(company3);

        company1.setEmail("tnova123@gmail.com");

        System.out.println("******Update Company******\n");
        System.out.println(company1.toString());
        adminService.updateCompany(company1.getId(), company1);

        System.out.println(company1.toString());
        System.out.println();
        System.out.println("******Delete Company Companies******\n");
        adminService.getAllCompanies().forEach(System.out::println);
        System.out.println();
        adminService.deleteCompany(company3.getId());

        try {
            adminService.deleteCompany(company3.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("*************************************\n");

        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println("******Get One Company******\n");

        System.out.println(adminService.getOneCompanyById(company1.getId()));
        System.out.println();
        try {
            System.out.println(adminService.getOneCompanyById(company1.getId()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        adminService.addCustomer(customer1);

        try {
            adminService.addCustomer(customer1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        adminService.addCustomer(customer2);
        adminService.addCustomer(customer3);

        customer2.setEmail("elias1@gmail.com");


        company1.setEmail("******Update Customer******\n");

        adminService.updateCustomer(customer2.getId(), customer2);
        System.out.println(customer2.toString());
        System.out.println();

        company1.setEmail("******Delete Customer******\n");

        adminService.getAllCustomers().forEach(System.out::println);

        adminService.deleteCustomer(customer3.getId());
        System.out.println();
        System.out.println("*************************************\n");
        adminService.getAllCustomers().forEach(System.out::println);
        System.out.println();

        System.out.println("******Get One Customer******\n");

        System.out.println(adminService.getOneCustomerById(customer1.getId()));
    }
}
