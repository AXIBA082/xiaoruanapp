package com.example.xiaoruan.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("User")
public class User  {

    @TableId(value="id")
    private String id;
    
    private String nickname;
    
    private String password;
    
    private String email;
    
    private String gender;
    
    private String school;

    private String avatar;

}

