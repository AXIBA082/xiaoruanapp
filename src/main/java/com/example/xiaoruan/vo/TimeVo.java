package com.example.xiaoruan.vo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeVo {
    public static String timeTransform(Date inputDateTime) {

        // 解析输入字符串
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 格式化为字符串
        String formattedDateTime = inputFormat.format(inputDateTime);

        return formattedDateTime;
    }
}
