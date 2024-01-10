package com.example.xiaoruan.controller;


import com.example.xiaoruan.service.PostsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("posts")
public class PostsController{

    @Resource
    private PostsService postsService;

}

