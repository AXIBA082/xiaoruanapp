package com.example.temp.controller;


import com.example.temp.service.QuestionService;
import com.example.temp.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("question")
public class QuestionController{
    @Resource
    private QuestionService questionService;

    @GetMapping("/get/{id}")
    public ResultVO sendemail(@PathVariable int id) {
        ResultVO resultVO = this.questionService.getQuestion(id);
        return resultVO;
    }

}

