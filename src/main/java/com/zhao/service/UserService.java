package com.zhao.service;

import com.zhao.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User queryByName(String name);
    User queryByUsername(String Username);
    int insertUser(User user);
}
