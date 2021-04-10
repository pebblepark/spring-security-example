package com.spring.security.example.user.service.impl;

import java.util.Optional;

import com.spring.security.example.user.repo.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.example.user.mapper.UserMapper;
import com.spring.security.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    private final UserJpaRepo userJpaRepo;

    public UserServiceImpl(UserJpaRepo userJpaRepo) {
        this.userJpaRepo = userJpaRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    return Optional.ofNullable(userJpaRepo.loadUserByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("아이디가 존재하지 않습니다."));
    }
    



}
