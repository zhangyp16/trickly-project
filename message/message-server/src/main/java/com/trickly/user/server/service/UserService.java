package com.trickly.user.server.service;

import com.trickly.user.server.dao.UserDao;
import com.trickly.user.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getById(Long id){
        return userDao.getById();
    }
}
