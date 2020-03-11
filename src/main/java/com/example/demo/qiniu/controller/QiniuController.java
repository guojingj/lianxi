package com.example.demo.qiniu.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.qiniu.service.IQiniuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/qiniu")
@Api(tags = "七牛云文件管理")
public class QiniuController {

    private static final Logger log = LoggerFactory.getLogger(QiniuController.class);

    @Autowired
    private IQiniuService qiniuService;

    public static final String TEMP_UPLOAD_PATH = "/tempFile";

    @PostMapping(value = "/upload")
    @ApiOperation("上传文件")
    public JSONObject upload(@RequestParam MultipartFile file, HttpServletRequest request) throws Exception {
        JSONObject ret = new JSONObject();
        File basePath = new File(request.getServletContext().getRealPath("") + TEMP_UPLOAD_PATH);
        if (!basePath.exists()) {
            basePath.mkdirs();
        }
        String nowTime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        long randomNum = Math.round(Math.random() * 1000);
        String key = nowTime + "_" + randomNum + file.getOriginalFilename();
        String tempPath = TEMP_UPLOAD_PATH + "/" + key;
        String absPath = request.getServletContext().getRealPath("") + tempPath;
        File target = new File(absPath);
        try {
            file.transferTo(target);
            String yunUrl = qiniuService.uploadFile(target,key);
            ret.put("url", yunUrl);
            ret.put("code", "0");
        } catch (IOException e) {
            log.error("upload to yun error:", e);
            ret.put("error", e.getMessage());
            ret.put("code", "-1");
        }
        return ret;
    }


}
