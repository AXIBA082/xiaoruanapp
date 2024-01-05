package com.example.temp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Verification")
public class Verification {

    @TableId(value="id",type = IdType.AUTO)
    private Integer id;

    private String email;

    private String code;

}

