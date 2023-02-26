package com.fetcher.drivinglicence.controller;

import com.fetcher.drivinglicence.request.LoginRequest;
import com.fetcher.drivinglicence.request.SignUpRequest;
import com.fetcher.drivinglicence.response.MessageResponse;
import com.fetcher.drivinglicence.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogingController {


    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageResponse createAccount(@RequestBody SignUpRequest signUpRequest) {
        if (!signUpRequest.getCnfPassword().equals(signUpRequest.getPassword())) {
            return MessageResponse.builder().message("Password and Confirm Password are not matching").status("failure").build();
        }
        return this.loginService.createAccount(signUpRequest);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageResponse loginAccount(@RequestBody LoginRequest loginRequest) {
        return this.loginService.loginAccount(loginRequest);
    }

}
