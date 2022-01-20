package com.tuanbaol.jshiro.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_user_role", schema = "auth")
public class UserRole {
    private Long id;
    private Long userId;
    private Long roleId;
}
