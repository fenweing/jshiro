package com.tuanbaol.jshiro.controller;

import com.tuanbaol.jshiro.bean.ResultMessage;
import com.tuanbaol.jshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{name}")
    public ResultMessage get(@PathVariable String name) {
        return ResultMessage.ok(userService.getUserByName(name));
    }
}
