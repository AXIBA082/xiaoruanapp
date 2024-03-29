package com.example.xiaoruan.service;

import com.example.xiaoruan.entity.User;
import com.example.xiaoruan.vo.ResultVO;


public interface UserService{
    ResultVO login(User userlogin);
    ResultVO registersendemail(String operation,String email);
    ResultVO register(User userregister);
    ResultVO registercode(String email,String code,String nickname);
    ResultVO getinfo(String email);

    ResultVO update(String email,String password);
    ResultVO judgepassword(String email,String oldpassword);

    ResultVO updateinfo(User user);

    ResultVO updateavatar(User user);
}

