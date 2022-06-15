package com.johnBryce.CouponSystem.controller;

import com.johnBryce.CouponSystem.dto.LoginDto;
import com.johnBryce.CouponSystem.exceptions.CustomException;
import com.johnBryce.CouponSystem.services.LoginManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/login/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class LoginController  extends ClientController  {


    final private LoginManager loginManager;

    @Override
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public UUID login(@RequestBody LoginDto loginDto) throws CustomException {
        return  loginManager.login(loginDto.getEmail(),loginDto.getPassword(),loginDto.getClientType());

    }



}
