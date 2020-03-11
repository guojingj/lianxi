package com.example.demo.subject.repository;

import com.example.demo.platform.mybatis.dao.BaseDao;
import com.example.demo.subject.entity.Subject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SubjectDao extends BaseDao<Subject,Long> {

    List<Subject> queryAll(@Param("subject") Subject subject);
    //新增
    void addQuestion(Subject subject);
    //批量删除
    void batchDelete(@Param("ids") String ids);
}
