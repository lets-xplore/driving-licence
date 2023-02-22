package com.fetcher.drivinglicence.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginRequest {
    private String username;
    private String email;
    private String password;
}
