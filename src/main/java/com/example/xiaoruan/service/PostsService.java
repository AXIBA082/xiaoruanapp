package com.example.xiaoruan.service;

import com.example.xiaoruan.entity.PostData;
import com.example.xiaoruan.entity.Posts;
import com.example.xiaoruan.vo.ResultVO;

public interface PostsService {
    ResultVO addpost(PostData postData);

    ResultVO getall();

    ResultVO getone(int postId);
}

