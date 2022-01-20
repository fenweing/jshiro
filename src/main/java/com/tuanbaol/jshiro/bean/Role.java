package com.tuanbaol.jshiro.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_role", schema = "auth")
public class Role {
    private Long id;
    private String name;

}
