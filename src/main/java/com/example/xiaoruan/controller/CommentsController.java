package com.example.xiaoruan.controller;


import com.example.xiaoruan.service.CommentsService;
import com.example.xiaoruan.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("comments")
public class CommentsController {

    @Resource
    private CommentsService commentsService;
    @GetMapping("/getcomments/{postId}")
    public ResultVO getcomments(@PathVariable int postId){
        ResultVO resultVO = this.commentsService.getcomments(postId);
        return resultVO;
    }
}

