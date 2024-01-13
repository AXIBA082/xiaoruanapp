package com.example.xiaoruan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xiaoruan.entity.Comment;
import com.example.xiaoruan.entity.Comments;
import com.example.xiaoruan.entity.Posts;
import com.example.xiaoruan.entity.User;
import com.example.xiaoruan.repository.CommentsRepository;
import com.example.xiaoruan.repository.PostsRepository;
import com.example.xiaoruan.repository.UserRepository;
import com.example.xiaoruan.service.CommentsService;
import com.example.xiaoruan.vo.ResultVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("commentsService")
public class CommentsServiceImpl  implements CommentsService {
    @Resource
    private CommentsRepository commentsRepository;

    @Resource
    private UserRepository userRepository;

    @Override
    public ResultVO getcomments(int postId){
        ResultVO resultVO = new ResultVO();
        QueryWrapper<Comments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("postid",postId);
        List<Comment> commentList=new ArrayList<>();
        List<Comments> commentsList=commentsRepository.selectList(queryWrapper);
        for(Comments a:commentsList){
            QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
            Comment temp = new Comment();
            queryWrapper1.eq("id",a.getUserid());
            temp.setNickname(userRepository.selectOne(queryWrapper1).getNickname());
            temp.setContent(a.getContent());
            commentList.add(temp);
        }
        resultVO.setCode(0);
        resultVO.setData(commentList);
        return resultVO;
    }
}

