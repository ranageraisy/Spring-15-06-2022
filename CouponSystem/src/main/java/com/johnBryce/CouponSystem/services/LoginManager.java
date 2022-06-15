package com.johnBryce.CouponSystem.services;

import com.johnBryce.CouponSystem.TokenManager.TokenManager;
import com.johnBryce.CouponSystem.TokenManager.Info;
import com.johnBryce.CouponSystem.beans.Company;
import com.johnBryce.CouponSystem.beans.Customer;
import com.johnBryce.CouponSystem.clientType.ClientType;
import com.johnBryce.CouponSystem.exceptions.CustomException;
import com.johnBryce.CouponSystem.exceptions.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LoginManager {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private AdminService admin;

    @Autowired
    private TokenManager tokenManager;

    public UUID login(String email, String password, ClientType clientType) throws CustomException {

        if (clientType == ClientType.ADMINISTRATOR) {

            if (((AdminServiceImp) admin).login(email, password)) {
                Info info = new Info(-1, "admin@admin.com", ClientType.ADMINISTRATOR);
                return tokenManager.addToken(info);
            }

        } else if (clientType == ClientType.COMPANY) {

            CompanyService company = ctx.getBean(CompanyService.class);

            if (((CompanyServiceImp) company).login(email, password)) {

                Company company1 = admin.getOneCompanyByEmail(email);
                Info info = new Info(company1.getId(), company1.getEmail(), ClientType.COMPANY);
                return tokenManager.addToken(info);
            }
        } else if (clientType == ClientType.CUSTOMER) {

            CustomerService customer = ctx.getBean(CustomerService.class);

            if (((CustomerServiceImp) customer).login(email, password)) {

                Customer customer1 = admin.getOneCustomerByEmail(email);
                Info info = new Info(customer1.getId(), customer1.getEmail(), ClientType.CUSTOMER);
                return tokenManager.addToken(info);
            }
        }
        throw new CustomException(ErrorMsg.ERROR_LOGIN);
    }

}
