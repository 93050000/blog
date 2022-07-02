package com.zhao.service.impl;

import com.zhao.mapper.UserMapper;
import com.zhao.pojo.User;
import com.zhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryByName(String name) {
        return userMapper.queryByName(name);
    }

    @Override
    public User queryByUsername(String Username) {
        return userMapper.queryByUsername(Username);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
