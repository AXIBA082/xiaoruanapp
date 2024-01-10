package com.example.xiaoruan.controller;


import com.example.xiaoruan.service.CommentsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("comments")
public class CommentsController {

    @Resource
    private CommentsService commentsService;

}

