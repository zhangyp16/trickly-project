package com.trickly.user.server.controller;

import com.trickly.user.server.model.User;
import com.trickly.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public User getById(){
        return userService.getById(0L);
    }
}
