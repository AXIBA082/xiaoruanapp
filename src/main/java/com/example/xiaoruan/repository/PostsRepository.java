package com.example.xiaoruan.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xiaoruan.entity.Posts;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PostsRepository extends BaseMapper<Posts> {

}

