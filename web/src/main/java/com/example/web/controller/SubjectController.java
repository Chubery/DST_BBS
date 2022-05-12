package com.example.web.controller;

import com.example.web.common.Cnst;
import com.example.web.common.ServerResponse;
import com.example.web.entity.User;
import com.example.web.re.createSubject;
import com.example.web.service.ISubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/subject")
@CrossOrigin
public class SubjectController {

    @Autowired
    ISubject subject;

    @PostMapping("/add")
    public ServerResponse<User> login(@RequestBody createSubject cSub, HttpSession session) {
        User user = (User)session.getAttribute(Cnst.CURRENT_USER);
        ServerResponse serverResponse = subject.addSubject(cSub, user);
        return serverResponse;
    }

    @GetMapping("/all")
    public ServerResponse allSubject() {
        ServerResponse serverResponse = subject.getAllSubject();
        return serverResponse;
    }

    @PostMapping("/select/{l_id}")
    public ServerResponse getSubjectByL(@PathVariable(name = "l_id")int l_id) {
        ServerResponse serverResponse = subject.selectSubjectL(l_id);
        return serverResponse;
    }


}
