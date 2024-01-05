package com.example.temp.service;

import com.example.temp.entity.User;
import com.example.temp.vo.ResultVO;


public interface UserService{
    ResultVO login(User userlogin);
    ResultVO registersendemail(String email);
    ResultVO register(User userregister,String code);
}

