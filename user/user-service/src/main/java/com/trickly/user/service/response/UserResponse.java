package com.trickly.user.service.response;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {

    private List<UserVO> userList;

    private Integer totalCount;
}
