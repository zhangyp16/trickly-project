package com.trickly.user.server.model;

import lombok.Data;

@Data
public class Message {

    private Long id;

    private String username;

    private String phone;

    private String password;

}
