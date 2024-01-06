package com.example.temp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.temp.config.AliyunConfig;
import com.example.temp.entity.User;
import com.example.temp.entity.Verification;
import com.example.temp.repository.UserRepository;
import com.example.temp.repository.VerificationRepository;
import com.example.temp.service.UserService;
import com.example.temp.vo.ResultVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Objects;
import java.util.Random;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private VerificationRepository verificationRepository;
    @Override
    public ResultVO login(User userlogin) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", userlogin.getEmail());
        User user = this.userRepository.selectOne(queryWrapper);
        ResultVO resultVO = new ResultVO();
        if(user == null){
            resultVO.setCode(-1);
            resultVO.setData("网络异常!");
        } else {
            if(!user.getPassword().equals(user.getPassword())){
                resultVO.setCode(-2);
                resultVO.setData("密码错误!");
            } else {
                resultVO.setCode(0);
                resultVO.setData(user);
            }
        }
        return resultVO;
    }
    @Override
    public ResultVO registersendemail(String email){
        Random random = new Random();
        int num=random.nextInt(900000) + 100000;
        String code = String.valueOf(num);
        Verification verification=new Verification();
        verification.setEmail(email);
        verification.setCode(code);
        verificationRepository.insert(verification);
        Session session= AliyunConfig.ConnectAliyun();
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("outsider0820@yigefengfeng.top"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("邮箱验证吗");
            message.setText("欢迎注册小软刷题app，您的验证码是"+code+",接下来的旅途就有我们一起度过吧(●'◡'●)!");
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(verification);
        return resultVO;
    }
    @Override
    public ResultVO register(User userregister,String code){
        QueryWrapper<Verification> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("email", userregister.getEmail());
        Verification verification = this.verificationRepository.selectOne(queryWrapper1);
        ResultVO resultVO = new ResultVO();
        if(Objects.equals(verification.getCode(), code)){
            Random random = new Random();
            int num=random.nextInt(900000) + 100000;
            String ID = String.valueOf(num);
            userregister.setId(ID);
            userRepository.insert(userregister);
            verificationRepository.delete(queryWrapper1);
            resultVO.setCode(0);
            resultVO.setData(userregister);
        }
        else{
            resultVO.setCode(-1);
            resultVO.setData("验证码错误");
        }
        return resultVO;
    }
}

