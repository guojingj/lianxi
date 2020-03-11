package com.example.demo.subject.service;

import com.example.demo.platform.mybatis.service.BaseService;
import com.example.demo.subject.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SubjectService extends BaseService<Subject,Long> {

    List<Subject> queryAll(Subject subject);
    //新增
    void addQuestion(Subject subject);
    //批量删除
    void batchDelete(@Param("ids") String ids);
}
