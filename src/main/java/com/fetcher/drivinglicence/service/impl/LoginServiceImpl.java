package com.fetcher.drivinglicence.service.impl;

import com.fetcher.drivinglicence.model.LoginModel;
import com.fetcher.drivinglicence.repository.LoginRepository;
import com.fetcher.drivinglicence.request.LoginRequest;
import com.fetcher.drivinglicence.request.SignUpRequest;
import com.fetcher.drivinglicence.response.MessageResponse;
import com.fetcher.drivinglicence.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public MessageResponse createAccount(SignUpRequest signUpRequest) {
        LoginModel loginModel = new LoginModel();
        loginModel.setEmail(signUpRequest.getEmail());
        loginModel.setPassword(signUpRequest.getPassword());
        this.loginRepository.save(loginModel);
        return MessageResponse.builder().message("Account created successfully").status("success").build();
    }

    public MessageResponse loginAccount(LoginRequest loginRequest) {
        LoginModel loginModel = this.loginRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());if (loginModel == null) {
            return MessageResponse.builder().status("failure").message("Either email or password is wrong").build();
        }
        return MessageResponse.builder().status("success").message("Logged in successfully").build();
    }
}
