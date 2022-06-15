package com.johnBryce.CouponSystem.dto;

import com.johnBryce.CouponSystem.clientType.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto {

    private String email;
    private String password;
    private  ClientType clientType;
}
