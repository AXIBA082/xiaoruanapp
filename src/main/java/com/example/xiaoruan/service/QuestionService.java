package com.example.xiaoruan.service;

import com.example.xiaoruan.vo.ResultVO;
import org.springframework.web.bind.annotation.PathVariable;


public interface QuestionService{
    ResultVO getQuestion(int id);

    ResultVO getTotal();

    ResultVO addQuestionTable( String id );

}

