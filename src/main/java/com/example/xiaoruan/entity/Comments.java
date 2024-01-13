package com.example.xiaoruan.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("Comments")
public class Comments  {

    @TableId(value="commentid")
    private Integer commentid;
    
    private Integer postid;
    
    private Integer userid;
    
    private String content;

}

