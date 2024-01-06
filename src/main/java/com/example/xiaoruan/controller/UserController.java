package com.example.xiaoruan.controller;


import com.example.xiaoruan.entity.User;
import com.example.xiaoruan.service.UserService;
import com.example.xiaoruan.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController{

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public ResultVO userlogin(@RequestBody User userlogin){
        ResultVO resultVO = this.userService.login(userlogin);
        return resultVO;
    }

    @GetMapping("/register/sendemail/{email}")
        public ResultVO sendemail(@PathVariable String email) {
            ResultVO resultVO = this.userService.registersendemail(email);
            return resultVO;
    }
    @GetMapping("/register/{code}")
    public ResultVO userregister(@RequestBody User userregister,@PathVariable String code){
        ResultVO resultVO = this.userService.register(userregister,code);
        return resultVO;
    }

    @GetMapping("/info/{id}")
    public ResultVO userinfo(@PathVariable int id ){
        ResultVO resultVO = this.userService.getinfo(id);
        return resultVO;
    }



}

