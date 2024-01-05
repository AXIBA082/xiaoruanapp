package com.example.temp.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.temp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository extends BaseMapper<User> {

}

