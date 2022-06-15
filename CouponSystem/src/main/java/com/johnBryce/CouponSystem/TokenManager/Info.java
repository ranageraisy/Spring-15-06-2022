package com.johnBryce.CouponSystem.TokenManager;

import com.johnBryce.CouponSystem.clientType.ClientType;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Info {

    private int id;
    private String email;
    private ClientType clientType;
    private LocalDateTime date =  LocalDateTime.now();

    public Info (int id, String email, ClientType clientType){
        this.id = id;
        this.email = email;
        this.clientType = clientType;
    }

}
