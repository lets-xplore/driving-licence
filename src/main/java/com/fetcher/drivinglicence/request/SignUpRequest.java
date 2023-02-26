package com.fetcher.drivinglicence.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String fullName;
    private String mobileNumber;
    private String email;
    private String password;
    private String cnfPassword;
}
