package com.fetcher.drivinglicence.service.impl;

import com.fetcher.drivinglicence.model.LoginModel;
import com.fetcher.drivinglicence.repository.LoginRepository;
import com.fetcher.drivinglicence.request.LoginRequest;
import com.fetcher.drivinglicence.response.MessageResponse;
import com.fetcher.drivinglicence.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public MessageResponse createAccount(LoginRequest loginRequest) {
        LoginModel loginModel = new LoginModel();
        loginModel.setEmail(loginRequest.getEmail());
        loginModel.setPassword(loginRequest.getPassword());
        this.loginRepository.save(loginModel);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Account created successfully");
        messageResponse.setStatus("success");
        return messageResponse;
    }

    public MessageResponse loginAccount(LoginRequest loginRequest) {
        LoginModel loginModel = this.loginRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        MessageResponse messageResponse = new MessageResponse();
        if (loginModel == null) {
            messageResponse.setStatus("failure");
            messageResponse.setMessage("Either email or password is wrong");
            return messageResponse;
        }
        messageResponse.setStatus("success");
        messageResponse.setMessage("Logged in successfully");
        return messageResponse;
    }
}
