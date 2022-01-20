package com.tuanbaol.jshiro.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuanbaol.jshiro.bean.User;
import com.tuanbaol.jshiro.dao.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserDAO, User> {
    public User getUserByName(String name) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getName, name);
        return getOne(wrapper);
    }
}
