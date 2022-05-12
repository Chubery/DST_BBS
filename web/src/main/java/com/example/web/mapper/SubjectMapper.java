package com.example.web.mapper;

import com.example.web.entity.Subject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper
public interface SubjectMapper {

    @Select("SELECT * FROM subject")
    List<Subject> getAllSubject();

    @Select("SELECT * FROM subject WHERE l_id = #{l_id}")
    List<Subject> selectSubjectL(int l_id);

    @Insert("INSERT INTO subject (uid, username, l_id, l_name, s_title, s_detail, create_time, last_reply_time, last_reply_username) values (#{uid}, #{username}, #{l_id}, #{l_name}, #{s_title}, #{s_detail}, #{create_time}, #{last_reply_time}, #{last_reply_username})")
    int addNewSubject(int uid, String username, int l_id, String l_name, String s_title, String s_detail, String create_time, String last_reply_time, String last_reply_username);

    @Update("")
    int update();

}
