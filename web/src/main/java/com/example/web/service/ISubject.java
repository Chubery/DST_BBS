package com.example.web.service;

import com.example.web.common.ServerResponse;
import com.example.web.entity.User;
import com.example.web.re.createSubject;

public interface ISubject {

    ServerResponse addSubject(createSubject cSubject, User user);

    ServerResponse getAllSubject();

    ServerResponse selectSubjectL(int l_id);

}
