package com.tuanbaol.jshiro.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_user", schema = "auth")
public class User {
    private Long id;
    private String name;
    private String phone;
    private String password;
    private Integer sex;

}
