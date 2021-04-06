package com.spring.security.example.user.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.security.example.user.dao.User;
import com.spring.security.example.user.mapper.UserMapper;
import com.spring.security.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    private final UserMapper userMapper;
    
    public UserServiceImpl(UserMapper userMapper) {
	this.userMapper = userMapper;
    }
    

    @Override
    public User findByUid(String uid) {
	return Optional.ofNullable(userMapper.findByUid(uid)).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

}
