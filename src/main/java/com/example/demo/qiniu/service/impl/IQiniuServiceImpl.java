package com.example.demo.qiniu.service.impl;

import com.example.demo.qiniu.service.IQiniuService;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class IQiniuServiceImpl implements IQiniuService {

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Auth auth;

    @Value("${qiniu.bucket}")
    private String bucket;
    @Value("${qiniu.path}")
    private String path;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @Override
    public String uploadFile(File file,String fileKey) {
        try {
            if (fileKey.startsWith("/")) {
                fileKey = fileKey.substring(1);
            }
            Response res = uploadManager.put(file, fileKey, getUploadToken());
            if (res.isOK()) {
                DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
                return path + putRet.key;
            }
        } catch (QiniuException e) {
            Response r = e.response;
            System.err.println(r.toString());
            e.printStackTrace();
        }
        return null;

    }



    /**
     * 根据key删除
     *
     * @param key
     * @throws QiniuException
     */
    @Override
    public void delete(String key) throws QiniuException {
        if (key.startsWith("/")) {
            key = key.substring(1);
        }
        bucketManager.delete(this.bucket, key);
    }


    /**
     * 获取上传凭证
     */
    private String getUploadToken() {
        return this.auth.uploadToken(bucket);
    }
}
