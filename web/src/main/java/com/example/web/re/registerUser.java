package com.example.web.re;

public class registerUser {
    private String username;
    private String password;
    private String email;
    private String captcha;

    public registerUser() {
    }

    public registerUser(String username, String password, String email, String captcha) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.captcha = captcha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
