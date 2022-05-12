package com.example.web.service.impl;

import com.example.web.common.ServerResponse;
import com.example.web.entity.Subject;
import com.example.web.entity.User;
import com.example.web.mapper.LabelMapper;
import com.example.web.mapper.SubjectMapper;
import com.example.web.re.createSubject;
import com.example.web.service.ISubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class SubjectImpl implements ISubject {

    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    LabelMapper labelMapper;

    @Override
    public ServerResponse addSubject(createSubject cSubject, User user) {
        int uid = user.getUid();
        String username = user.getUsername();
        int l_id = cSubject.getL_id();
        String l_name = labelMapper.findLabel(l_id).getL_name();
        String s_title = cSubject.getS_title();
        String s_detail = cSubject.getS_detail();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String create_time = simpleDateFormat.format(date.getTime());
        String last_reply_time = simpleDateFormat.format(date.getTime());
        String last_reply_username = user.getUsername();

        int add = subjectMapper.addNewSubject(uid, username, l_id, l_name, s_title, s_detail, create_time, last_reply_time, last_reply_username);
        if (add == 0)
            return ServerResponse.failWithMsg("other error");
        else
            return ServerResponse.successWithMsg("add success!");
    }

    @Override
    public ServerResponse getAllSubject() {
        List<Subject> subjectList = subjectMapper.getAllSubject();
        Collections.reverse(subjectList);
        return ServerResponse.successWithMsgData("获取所有主题成功", subjectList);
    }

    @Override
    public ServerResponse selectSubjectL(int l_id) {
        List<Subject> subjectList = subjectMapper.selectSubjectL(l_id);
        Collections.reverse(subjectList);
        return ServerResponse.successWithMsgData("筛选主题成功", subjectList);
    }
}
