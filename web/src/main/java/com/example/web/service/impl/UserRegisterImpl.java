package com.example.web.service.impl;

import com.example.web.common.ResponseCode;
import com.example.web.common.ServerResponse;
import com.example.web.mapper.UserMapper;
import com.example.web.re.registerUser;
import com.example.web.service.IUserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserRegisterImpl implements IUserRegister {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse checkUsername(String username) {
        if (userMapper.check(username) == 1)
            return ServerResponse.failWithCodeMsg(ResponseCode.ERROR.getCode(), "用户名已存在");
        else
            return ServerResponse.success();
    }

    @Override
    public ServerResponse register(registerUser registerUser) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String trueCaptcha = (String) request.getSession().getAttribute("CAPTCHA");

        if (!registerUser.getCaptcha().equalsIgnoreCase(trueCaptcha)) {
            return new ServerResponse<>(ResponseCode.ERROR.getCode(), "验证码错误", null);
        } else {
            int add = userMapper.add(registerUser);
            if (add == 0)
                return ServerResponse.failWithMsg("other error");
            else
                return ServerResponse.successWithMsg("register success!");
        }
    }

}
