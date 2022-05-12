package com.example.web.service;

import com.example.web.common.ServerResponse;
import com.example.web.re.registerUser;

public interface IUserRegister {

    ServerResponse checkUsername(String username);

    ServerResponse register(registerUser registerUser);
}
