package com.market.efair.dtos;

public class LoginDto{

    private String email;
    private String password;

    public LoginDto() {}

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
