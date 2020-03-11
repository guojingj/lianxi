package com.example.demo.qiniu.service;

import com.qiniu.common.QiniuException;

import java.io.File;


public interface IQiniuService {

    String uploadFile(File file, String fileKey) throws QiniuException;

    void delete(String key) throws QiniuException;
}
