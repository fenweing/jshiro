package com.tuanbaol.jshiro.controller;

import com.tuanbaol.jshiro.bean.ResultMessage;
import com.tuanbaol.jshiro.service.RoleService;
import com.tuanbaol.jshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/getByName/{name}")
    public ResultMessage getByName(@PathVariable String name) {
        return ResultMessage.ok(roleService.getByName(name));
    }
}
