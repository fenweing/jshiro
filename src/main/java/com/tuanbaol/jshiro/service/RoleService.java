package com.tuanbaol.jshiro.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuanbaol.jshiro.bean.Role;
import com.tuanbaol.jshiro.bean.UserRole;
import com.tuanbaol.jshiro.dao.RoleDAO;
import com.tuanbaol.jshiro.dao.UserRoleDAO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService extends ServiceImpl<RoleDAO, Role> {

    public List<String> getNamesByUserName(String name) {
        List<Role> rolesByUserName = getByUserName(name);
        List<String> roleNames = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(rolesByUserName)) {
            roleNames = rolesByUserName.stream().map(item -> item.getName().toString()).collect(Collectors.toList());
        }
        return roleNames;
    }

    public List<Role> getByUserName(String name) {
        return getBaseMapper().getByUserName(name);
    }

    public Role getByName(String name) {
        LambdaQueryWrapper<Role> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Role::getName, name);
        return getOne(wrapper);
    }
}
