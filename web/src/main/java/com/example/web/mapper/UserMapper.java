package com.example.web.mapper;

import com.example.web.entity.User;
import com.example.web.re.registerUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT count(1) FROM user WHERE username=#{username}")
    int check(String username);

    @Select("SELECT * FROM user WHERE username=#{username} and password=#{password}")
    User login(String username, String password);

    @Insert("INSERT INTO user (username, password, email) values (#{username}, #{password}, #{email});")
    int add(registerUser registerUser);
}
