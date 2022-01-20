package com.tuanbaol.jshiro.controller;

import com.tuanbaol.jshiro.bean.ResultMessage;
import com.tuanbaol.jshiro.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @PostMapping("/login")
    public ResultMessage login(@RequestBody User user) {
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getName(), user.getPassword()));
            return ResultMessage.ok();
        } catch (Exception e) {
            log.error("login failed", e);
            return ResultMessage.failed("401", "login failed");
        }
    }

    @PostMapping("/logout")
    public ResultMessage login() {
        try {
            SecurityUtils.getSubject().logout();
            return ResultMessage.ok();
        } catch (Exception e) {
            log.error("logout failed", e);
            return ResultMessage.failed();
        }
    }
}
