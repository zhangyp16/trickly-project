package com.trickly.user.server.rpc;

import com.trickly.user.service.api.UserRpcService;
import com.trickly.user.service.request.LoginRequest;
import com.trickly.user.service.request.UserRequest;
import com.trickly.user.service.response.LoginResponse;
import com.trickly.user.service.response.UserResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpc-user")
public class UserRpcController implements UserRpcService {
    @Override
    public UserResponse getUserList(UserRequest request) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public LoginResponse register(LoginRequest request) {
        return null;
    }
}
