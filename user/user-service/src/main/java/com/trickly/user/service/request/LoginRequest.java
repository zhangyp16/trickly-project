package com.trickly.user.service.request;

import lombok.Data;

@Data
public class LoginRequest {

    /**
     * 1: 手机号登录 2: 用户名密码登录
     */
    private Integer loginType;

    private String phone;

    private String username;

    private String password;

}
