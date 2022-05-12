package com.example.web.service;

import com.example.web.common.ServerResponse;

public interface IUserLogin {
    ServerResponse login(String username, String password, String captcha);
}
