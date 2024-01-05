package com.example.temp.config;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class AliyunConfig {

    public static Session ConnectAliyun() {
        final String username = "outsider0820@yigefengfeng.top";
        final String password = "BFSYrgz0820";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtpdm.aliyun.com"); // 域名SMTP服务器地址
        props.put("mail.smtp.port", "80"); // 域名SMTP服务器端口

        return Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
}
