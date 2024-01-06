package com.example.temp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName("Question")
public class Question extends Model<Question> {

    @TableId(value="id",type = IdType.AUTO)
    private Integer id;

    private String description;

    private String a;

    private String b;

    private String c;

    private String d;

    private String answer;

    private String explanation;

    }

