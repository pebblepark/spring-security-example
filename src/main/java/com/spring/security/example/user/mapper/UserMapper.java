package com.spring.security.example.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.spring.security.example.user.dao.User;

@Mapper
@Repository
public interface UserMapper {

    User loadUserByUsername(String username);

}
