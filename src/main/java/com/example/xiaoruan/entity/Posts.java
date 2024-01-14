package com.example.xiaoruan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@Data
@TableName("Posts")
public class Posts {

    @TableId(value="postid",type = IdType.AUTO)
    private Integer postid;

    private Integer userid;

    private Date posttime;

    private String title;

    private String content;

    private String image1;

    private String image2;

    private String image3;

}

