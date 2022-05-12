package com.example.web.mapper;

import com.example.web.entity.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface LabelMapper {

    @Select("SELECT * FROM label")
    List<Label> getLabel();

    @Select("SELECT * FROM label WHERE l_id=#{l_id}")
    Label findLabel(int l_id);
}
