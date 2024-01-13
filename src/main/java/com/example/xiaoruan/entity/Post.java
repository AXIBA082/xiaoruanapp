package com.example.xiaoruan.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Post {

    private Integer postid;

    private Integer userid;

    private String nickname;

    private String avatar;

    private String posttime;

    private String title;

    private String content;

    private String image1;

    private String image2;

    private String image3;
}
