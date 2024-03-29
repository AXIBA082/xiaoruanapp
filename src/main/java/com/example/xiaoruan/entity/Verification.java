package com.example.xiaoruan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("Verification")
public class Verification{
    @TableId(value="id",type = IdType.AUTO)
    private Integer id;
    
    private String email;
    
    private String code;
    
    private Date createdtime;

}

