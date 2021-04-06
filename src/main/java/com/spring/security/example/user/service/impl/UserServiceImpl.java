package com.spring.security.example.user.service.impl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.example.user.mapper.UserMapper;
import com.spring.security.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    private final UserMapper userMapper;
    
    public UserServiceImpl(UserMapper userMapper) {
	this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	return Optional.ofNullable(userMapper.loadUserByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("아이디가 존재하지 않습니다."));
    }
    



}
