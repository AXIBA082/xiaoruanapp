package com.example.xiaoruan.controller;


import com.example.xiaoruan.entity.PostData;
import com.example.xiaoruan.entity.Posts;
import com.example.xiaoruan.service.PostsService;
import com.example.xiaoruan.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("posts")
public class PostsController{

    @Resource
    private PostsService postsService;
    @GetMapping("/getall")
    public ResultVO getAll(){
        ResultVO resultVO = this.postsService.getall();
        return resultVO;
    }

    @GetMapping("/getone/{postId}")
    public ResultVO getOne(@PathVariable int postId){
        ResultVO resultVO = this.postsService.getone(postId);
        return resultVO;
    }


    @PostMapping("/addpost")
    public ResultVO addPost(@RequestBody PostData postData){
        ResultVO resultVO = this.postsService.addpost(postData);
        return resultVO;
    }



}

