package com.example.xiaoruan.controller;


import com.example.xiaoruan.entity.CommentData;
import com.example.xiaoruan.entity.User;
import com.example.xiaoruan.service.CommentsService;
import com.example.xiaoruan.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addcomments")
    public ResultVO addcomments(@RequestBody CommentData commentData){
        ResultVO resultVO = this.commentsService.addcomments(commentData);
        return resultVO;
    }

}

