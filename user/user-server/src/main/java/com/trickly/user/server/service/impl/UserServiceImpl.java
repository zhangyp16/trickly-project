package com.trickly.user.server.service.impl;

import com.trickly.user.service.api.UserService;
import com.trickly.user.service.request.UserRequest;
import com.trickly.user.service.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserResponse getUserList(UserRequest request) {
        return null;
    }
}
