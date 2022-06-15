package com.johnBryce.CouponSystem.controller;

import com.johnBryce.CouponSystem.dto.LoginDto;
import com.johnBryce.CouponSystem.exceptions.CustomException;
import com.johnBryce.CouponSystem.services.LoginManager;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public abstract class  ClientController extends LoginManager {

    public abstract UUID login(LoginDto loginDto) throws CustomException;

}
