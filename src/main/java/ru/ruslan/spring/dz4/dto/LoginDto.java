package ru.ruslan.spring.dz4.dto;

import lombok.Data;


public class LoginDto {
    private String login;
    private String password;

    public LoginDto() {
    }

    public LoginDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDto(String password) {
        this.password = password;
    }
}
