package com.fetcher.drivinglicence.service;

import com.fetcher.drivinglicence.request.LoginRequest;
import com.fetcher.drivinglicence.response.MessageResponse;

public interface LoginService {
    MessageResponse createAccount(LoginRequest loginRequest);

    MessageResponse loginAccount(LoginRequest loginRequest);
}
