package com.trickly.user.service.api;

import com.trickly.user.service.request.LoginRequest;
import com.trickly.user.service.request.UserRequest;
import com.trickly.user.service.response.LoginResponse;
import com.trickly.user.service.response.UserResponse;

public interface UserRpcService {

    UserResponse getUserList(UserRequest request);

    LoginResponse login(LoginRequest request);

    LoginResponse register(LoginRequest request);
}
