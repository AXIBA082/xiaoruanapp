package com.example.temp.service.impl;

import com.example.temp.entity.Question;
import com.example.temp.repository.QuestionRepository;
import com.example.temp.service.QuestionService;
import com.example.temp.vo.ResultVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service("questionService")
public class QuestionServiceImpl  implements QuestionService {
    @Resource
    private QuestionRepository questionRepository;
    @Override
    public ResultVO getQuestion(int id){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        Question question=questionRepository.selectById(id);
        resultVO.setData(question);
        return resultVO;
    }
}

