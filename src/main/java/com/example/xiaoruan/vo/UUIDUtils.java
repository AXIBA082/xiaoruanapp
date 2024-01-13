package com.example.xiaoruan.vo;

import java.util.UUID;

public class UUIDUtils {
    public static String generateUniqueFileName() {
        // 生成随机的UUID字符串作为文件名
        String uuid = UUID.randomUUID().toString();
        // 去除UUID字符串中的横线，并转换为小写
        return uuid.replaceAll("-", "").toLowerCase();
    }
}