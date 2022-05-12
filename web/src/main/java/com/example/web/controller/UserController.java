package com.example.web.controller;

import com.example.web.common.Cnst;
import com.example.web.common.ResponseCode;
import com.example.web.common.ServerResponse;
import com.example.web.entity.User;
import com.example.web.re.loginUser;
import com.example.web.re.registerUser;
import com.example.web.service.IUserLogin;
import com.example.web.service.IUserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@CrossOrigin

public class UserController {

    @Autowired
    IUserLogin userLogin;
    @Autowired
    IUserRegister userRegister;

    @PostMapping("/login")
    public ServerResponse<User> login(@RequestBody loginUser loginUser, HttpSession session) {

        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        String captcha = loginUser.getCaptcha();

        System.out.println(username+" "+password+" "+captcha);

        ServerResponse serverResponse = userLogin.login(username, password, captcha);

        if (serverResponse.isSuccess())
            session.setAttribute(Cnst.CURRENT_USER, serverResponse.getData());
        return serverResponse;
    }

    @GetMapping("/check")
    public ServerResponse<User> getLogin(HttpSession session) {
        User loginUser = (User) session.getAttribute(Cnst.CURRENT_USER);

        if (loginUser == null)
            return ServerResponse.failWithCodeMsg(ResponseCode.NEED_LOGIN.getCode(), "未登录");
        else {
            loginUser.setPassword(null);
            return ServerResponse.successWithMsgData("成功获取", loginUser);

        }
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute(Cnst.CURRENT_USER);
    }


    @PostMapping("/checkname")
    public ServerResponse<User> checkUsername(@RequestBody registerUser registerUser) {
        String username = registerUser.getUsername();
        if (userRegister.checkUsername(username).isSuccess())
            return ServerResponse.successWithMsg("用户名合法");
        else
            return ServerResponse.failWithMsg("用户名已存在");
    }

    @PostMapping("/register")
    public ServerResponse<User> register(@RequestBody(required=false) registerUser registerUser) {
        ServerResponse register = userRegister.register(registerUser);

        if (register.isSuccess())
            return ServerResponse.successWithMsg(register.getMsg());
        else
            return ServerResponse.failWithMsg(register.getMsg());
    }

}
