package com.example.xiaoruan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xiaoruan.config.AliyunConfig;
import com.example.xiaoruan.entity.User;
import com.example.xiaoruan.entity.Verification;
import com.example.xiaoruan.repository.UserRepository;
import com.example.xiaoruan.repository.VerificationRepository;
import com.example.xiaoruan.service.UserService;
import com.example.xiaoruan.vo.ResultVO;
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
    public ResultVO registersendemail(String operation,String email){
        ResultVO resultVO = new ResultVO();
        if(Objects.equals(operation, "R")){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("email", email);
            User user = this.userRepository.selectOne(queryWrapper);
            if(user!=null){
                resultVO.setCode(-1);
                resultVO.setData("邮箱已注册！");
                return resultVO;
            }
        }
        String code= "";
        QueryWrapper<Verification> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("email", email);
        Verification verification=this.verificationRepository.selectOne(queryWrapper1);
        if(verification==null){
            Random random = new Random();
            int num=random.nextInt(900000) + 100000;
            code = String.valueOf(num);
            verification = new Verification();
            verification.setEmail(email);
            verification.setCode(code);
            verificationRepository.insert(verification);
        }
        code=verification.getCode();
        Session session= AliyunConfig.ConnectAliyun();
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("outsider0820@yigefengfeng.top"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("邮箱验证");
            message.setText("欢迎注册小软刷题app，您的验证码是"+code+",接下来的旅途就由我们一起度过吧(●'◡'●)!");
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resultVO.setCode(0);
        resultVO.setData(verification);
        return resultVO;
    }
    @Override
    public ResultVO registercode(String email, String code,String nickname){
        ResultVO resultVO = new ResultVO();
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("nickname", nickname);
        if(this.userRepository.selectOne(queryWrapper1)!=null){
            resultVO.setCode(-3);
            resultVO.setData("昵称重复");
            return resultVO;
        }
        QueryWrapper<Verification> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        Verification verification = this.verificationRepository.selectOne(queryWrapper);
        if(verification==null){
            resultVO.setCode(-1);
            resultVO.setData("验证码已过期或未发送！");
        }
        else if(Objects.equals(verification.getCode(), code)){
            resultVO.setCode(0);
            resultVO.setData("验证成功！");
        }
        else{
            resultVO.setCode(-2);
            resultVO.setData("验证码错误");
        }
        return resultVO;
    }
    @Override
    public ResultVO register(User userregister){
        ResultVO resultVO = new ResultVO();
        Random random = new Random();
        int num=random.nextInt(900000) + 100000;
        String ID = String.valueOf(num);
        userregister.setId(ID);
        userRepository.insert(userregister);
        resultVO.setCode(0);
        resultVO.setData(userregister);
        return resultVO;
    }
    @Override
    public ResultVO getinfo(int id){
        User user=userRepository.selectById(id);
        ResultVO resultVO = new ResultVO();
        if(user!=null){
            resultVO.setCode(0);
            resultVO.setData(user);
        }
        else{
            resultVO.setCode(-1);
            resultVO.setData("用户不存在");
        }
        return resultVO;
    }
}

