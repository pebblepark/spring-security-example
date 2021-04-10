package com.spring.security.example.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.spring.security.example.user.dao.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE uid = #{uid}")
    User loadUserByUsername(String username);

}
