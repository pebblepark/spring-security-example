package com.spring.security.example.user.service;

import com.spring.security.example.user.dao.User;

public interface UserService {

    User findByUid(String uid);

}
