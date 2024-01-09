package com.example.xiaoruan.controller;


import com.example.xiaoruan.service.QuestionService;
import com.example.xiaoruan.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("question")
public class QuestionController{
    @Resource
    private QuestionService questionService;

    @GetMapping("/get/{id}")
    public ResultVO getquestion(@PathVariable int id) {
        ResultVO resultVO = this.questionService.getQuestion(id);
        return resultVO;
    }

    @GetMapping("/gettotal")
    public ResultVO gettotal() {
        ResultVO resultVO = this.questionService.getTotal();
        return resultVO;
    }


}

