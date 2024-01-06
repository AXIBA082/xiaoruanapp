package com.example.xiaoruan.service.impl;

import com.example.xiaoruan.entity.Question;
import com.example.xiaoruan.repository.QuestionRepository;
import com.example.xiaoruan.service.QuestionService;
import com.example.xiaoruan.vo.ResultVO;
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

