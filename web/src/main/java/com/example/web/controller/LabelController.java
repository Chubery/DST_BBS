package com.example.web.controller;


import com.example.web.common.ServerResponse;
import com.example.web.service.ILabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/label")
@CrossOrigin

public class LabelController {

    @Autowired
    ILabel label;

    @GetMapping("/all")
    public ServerResponse getAllLabel() {
        ServerResponse serverResponse = label.getAllLabel();
        return serverResponse;
    }

}
