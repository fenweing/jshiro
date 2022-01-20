package com.tuanbaol.jshiro.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuanbaol.jshiro.bean.UserRole;
import com.tuanbaol.jshiro.dao.UserRoleDAO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleService extends ServiceImpl<UserRoleDAO, UserRole> {

    public List<String> getRoleIdsByUserName(String name) {
        List<UserRole> userRolesByUserName = getBaseMapper().getByUserName(name);
        List<String> roleIds = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(userRolesByUserName)) {
            roleIds = userRolesByUserName.stream().map(item -> item.getRoleId().toString()).collect(Collectors.toList());
        }
        return roleIds;
    }
}
