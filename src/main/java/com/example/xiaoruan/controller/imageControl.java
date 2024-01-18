package com.example.xiaoruan.controller;


import com.example.xiaoruan.vo.UUIDUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping
public class imageControl {

    @Value("${pictureFile.path}")
    private String picturePath;

    @Value("${pictureFile.path-mapping}")
    private String picturePath_mapping;
//这个写在了配置文件中

    @PostMapping("/upload/img")
    public String upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName = UUIDUtils.generateUniqueFileName() + suffixName; // 新文件名
        File dest = new File(picturePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String final_fileName = "http://183.136.206.184:21731" + picturePath_mapping + fileName;
        System.out.println(final_fileName);
        return final_fileName;
    }


}

