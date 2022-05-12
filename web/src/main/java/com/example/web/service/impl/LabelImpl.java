package com.example.web.service.impl;

import com.example.web.common.ServerResponse;
import com.example.web.mapper.LabelMapper;
import com.example.web.service.ILabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelImpl implements ILabel {

    @Autowired
    LabelMapper labelMapper;

    @Override
    public ServerResponse getAllLabel() {
        List labelList = labelMapper.getLabel();
        return ServerResponse.successWithMsgData("获取成功", labelList);
    }
}
