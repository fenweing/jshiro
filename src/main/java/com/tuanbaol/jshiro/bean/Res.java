package com.tuanbaol.jshiro.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_res", schema = "auth")
public class Res {
    private Long id;
    private String name;
    private String menu;
    private String url;

}
