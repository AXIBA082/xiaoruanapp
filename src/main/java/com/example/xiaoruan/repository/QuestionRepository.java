package com.example.xiaoruan.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xiaoruan.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface QuestionRepository extends BaseMapper<Question> {
    @Select("CALL AddTable(#{id})")
    void addtable(@Param("id") String id );
}

