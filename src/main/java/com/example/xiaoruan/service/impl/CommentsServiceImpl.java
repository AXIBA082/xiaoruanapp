package com.example.xiaoruan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xiaoruan.entity.Comments;
import com.example.xiaoruan.entity.Posts;
import com.example.xiaoruan.repository.CommentsRepository;
import com.example.xiaoruan.repository.PostsRepository;
import com.example.xiaoruan.service.CommentsService;
import com.example.xiaoruan.vo.ResultVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("commentsService")
public class CommentsServiceImpl  implements CommentsService {
    @Resource

    private CommentsRepository commentsRepository;

    @Override
    public ResultVO getcomments(int postId){
        ResultVO resultVO = new ResultVO();
        QueryWrapper<Comments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("postid",postId);
        List<Comments> commentsList=commentsRepository.selectList(queryWrapper);
        resultVO.setCode(0);
        resultVO.setData(commentsList);
        return resultVO;
    }
}

