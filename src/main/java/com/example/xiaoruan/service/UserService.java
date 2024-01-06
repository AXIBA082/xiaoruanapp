package com.example.xiaoruan.service;

import com.example.xiaoruan.entity.User;
import com.example.xiaoruan.vo.ResultVO;


public interface UserService{
    ResultVO login(User userlogin);
    ResultVO registersendemail(String email);
    ResultVO register(User userregister,String code);

    ResultVO getinfo(int id);
}

