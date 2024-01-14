package com.example.xiaoruan.service;

import com.example.xiaoruan.entity.CommentData;
import com.example.xiaoruan.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommentsService  {
    ResultVO getcomments(int postId);

    ResultVO addcomments(CommentData commentData);
}

