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
    @GetMapping("/find/{email}/{oldpassword}")
    public ResultVO judgment_oldpassword(@PathVariable String email,@PathVariable String oldpassword) {
        ResultVO resultVO = this.userService.judgepassword(email,oldpassword);
        return resultVO;
    }

    @GetMapping ("/update/{email}/{password}")
    public ResultVO updateuser(@PathVariable String email,@PathVariable String password) {
        ResultVO resultVO = this.userService.update(email,password);
        return resultVO;
    }

    @PostMapping  ("/updateinfo")
    public ResultVO updateinfo(@RequestBody User user) {
        ResultVO resultVO = this.userService.updateinfo(user);
        return resultVO;
    }

    @PostMapping  ("/updateavatar")
    public ResultVO updaetavatar(@RequestBody User user) {
        ResultVO resultVO = this.userService.updateavatar(user);
        return resultVO;
    }

    @GetMapping("/register/sendemail/{operation}/{email}")
        public ResultVO sendemail(@PathVariable String operation,@PathVariable String email) {
            ResultVO resultVO = this.userService.registersendemail(operation,email);
            return resultVO;
    }
    @GetMapping("/register/code/{email}/{code}/{nickname}")
    public ResultVO userregister(@PathVariable String email,@PathVariable String code,@PathVariable String nickname){
        ResultVO resultVO = this.userService.registercode(email,code,nickname);
        return resultVO;
    }
    @PostMapping("/register")
    public ResultVO userregister(@RequestBody User userregister){
        ResultVO resultVO = this.userService.register(userregister);
        return resultVO;
    }
    @GetMapping("/info/{email}")
    public ResultVO userinfo(@PathVariable String email ){
        ResultVO resultVO = this.userService.getinfo(email);
        return resultVO;
    }





}

