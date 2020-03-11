package com.example.demo.paper.service;

import com.example.demo.paper.entity.PaperClassification;
import com.example.demo.platform.mybatis.service.BaseService;

public interface PaperClassificationService extends BaseService<PaperClassification,Long> {

    void edit(PaperClassification paperClassification);
}
