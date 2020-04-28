package com.trickly.user.service.api;

import com.trickly.user.service.request.UserRequest;
import com.trickly.user.service.response.UserResponse;

public interface UserService {

    UserResponse getUserList(UserRequest request);
}
