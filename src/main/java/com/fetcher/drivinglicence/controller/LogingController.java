package com.fetcher.drivinglicence.controller;

import com.fetcher.drivinglicence.request.LoginRequest;
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

    @PostMapping(value = "/create/account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageResponse createAccount(@RequestBody LoginRequest loginRequest) {
        return this.loginService.createAccount(loginRequest);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageResponse loginAccount(@RequestBody LoginRequest loginRequest) {
        return this.loginService.loginAccount(loginRequest);
    }

}
