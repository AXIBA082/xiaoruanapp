package com.example.xiaoruan.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xiaoruan.entity.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommentsRepository extends BaseMapper<Comments> {

}

