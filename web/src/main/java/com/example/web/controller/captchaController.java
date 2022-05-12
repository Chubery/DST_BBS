package com.example.web.controller;

import com.example.web.utils.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@Controller
@CrossOrigin
public class captchaController {

    @RequestMapping("/captcha")
    public void getCaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Captcha captcha = new Captcha();
        BufferedImage image = captcha.getImage();
        request.getSession().setAttribute("CAPTCHA", captcha.getText());
        captcha.output(image, response.getOutputStream());
        System.out.println(captcha.getText());
    }

}
