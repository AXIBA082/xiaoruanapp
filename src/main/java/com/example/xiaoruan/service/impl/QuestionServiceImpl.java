package com.example.xiaoruan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    @Override
    public ResultVO getTotal(){
        ResultVO resultVO=new ResultVO();
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        resultVO.setData(questionRepository.selectCount(queryWrapper));
        return resultVO;
    }
    @Override
    public ResultVO addQuestionTable(String id){
        ResultVO resultVO=new ResultVO();
        questionRepository.addtable(id);
        resultVO.setData("table"+id+"表已创建！");
        resultVO.setCode(0);
        return resultVO;
    }
}

