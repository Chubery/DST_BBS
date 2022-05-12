package com.example.web.service.impl;

import com.example.web.common.ResponseCode;
import com.example.web.common.ServerResponse;
import com.example.web.entity.User;
import com.example.web.mapper.UserMapper;
import com.example.web.service.IUserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserLoginImpl implements IUserLogin {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse login (String username, String password, String captcha) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String trueCaptcha = (String) request.getSession().getAttribute("CAPTCHA");

        if (!captcha.equalsIgnoreCase(trueCaptcha)) {
            return new ServerResponse<>(ResponseCode.ERROR.getCode(), "验证码错误", null);
        } else if (userMapper.check(username) == 0) {
            return new ServerResponse<>(ResponseCode.ERROR.getCode(), "用户名不存在", null);
        } else {
            User user= userMapper.login(username, password);
            if (user == null) {
                return new ServerResponse<>(ResponseCode.ERROR.getCode(), "密码错误", null);
            } else {
                user.setPassword(null);
                return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), "登录成功", user);
            }
        }
    }
}
