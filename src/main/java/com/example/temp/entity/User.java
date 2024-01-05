package com.example.temp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("User")
public class User  {

    @TableId(value="id",type = IdType.AUTO)
    private Integer id;
    
    private String nickname;
    
    private String password;
    
    private String email;
    
    private String gender;
    
    private String school;

}

