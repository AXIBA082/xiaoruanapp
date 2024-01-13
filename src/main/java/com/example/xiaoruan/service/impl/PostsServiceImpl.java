package com.example.xiaoruan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xiaoruan.entity.Post;
import com.example.xiaoruan.entity.Posts;
import com.example.xiaoruan.entity.User;
import com.example.xiaoruan.repository.PostsRepository;
import com.example.xiaoruan.repository.UserRepository;
import com.example.xiaoruan.service.PostsService;
import com.example.xiaoruan.vo.ResultVO;
import com.example.xiaoruan.vo.TimeVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("postsService")
public class PostsServiceImpl  implements PostsService {


    @Resource

    private PostsRepository postsRepository;

    @Resource

    private UserRepository userRepository;

    @Override
    public ResultVO addpost(Posts posts){
        ResultVO resultVO = new ResultVO();
        postsRepository.insert(posts);
        resultVO.setCode(0);
        resultVO.setData(posts);
        return resultVO;
    }

    @Override
    public ResultVO getall(){
        ResultVO resultVO = new ResultVO();
        QueryWrapper<Posts> queryWrapper = new QueryWrapper<>();
        List<Posts> postsList=postsRepository.selectList(queryWrapper);
        List<Post> postList=new ArrayList<>();
        for(Posts a:postsList){
            QueryWrapper<User> queryWrapper1= new QueryWrapper<>();
            queryWrapper1.eq("id", a.getUserid());
            User user=userRepository.selectOne(queryWrapper1);
            Post post=new Post();
            post.setPostid(a.getPostid());
            post.setUserid(a.getUserid());
            post.setNickname(user.getNickname());
            post.setAvatar(user.getAvatar());
            post.setPosttime(TimeVo.timeTransform(a.getPosttime()));
            post.setTitle(a.getTitle());
            post.setContent(a.getContent());
            post.setImage1(a.getImage1());
            post.setImage2(a.getImage2());
            post.setImage3(a.getImage3());
            postList.add(post);
        }
        resultVO.setCode(0);
        resultVO.setData(postList);
        return resultVO;
    }
    @Override
    public ResultVO getone(int postId){
        ResultVO resultVO = new ResultVO();
        QueryWrapper<Posts> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("postid", postId);
        Posts posts=postsRepository.selectOne(queryWrapper);
        QueryWrapper<User> queryWrapper1= new QueryWrapper<>();
        queryWrapper1.eq("id", posts.getUserid());
        User user=userRepository.selectOne(queryWrapper1);
        Post post=new Post();
        post.setPostid(posts.getPostid());
        post.setUserid(posts.getUserid());
        post.setNickname(user.getNickname());
        post.setAvatar(user.getAvatar());
        post.setPosttime(TimeVo.timeTransform(posts.getPosttime()));
        post.setTitle(posts.getTitle());
        post.setContent(posts.getContent());
        post.setImage1(posts.getImage1());
        post.setImage2(posts.getImage2());
        post.setImage3(posts.getImage3());
        resultVO.setData(0);
        resultVO.setData(post);
        return resultVO;
    }
}

