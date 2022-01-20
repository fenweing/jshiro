package com.tuanbaol.jshiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tuanbaol.jshiro.bean.Role;
import com.tuanbaol.jshiro.bean.User;
import com.tuanbaol.jshiro.bean.UserRole;

import java.util.List;

public interface UserRoleDAO extends BaseMapper<UserRole> {
    List<UserRole> getByUserName(String name);
}
