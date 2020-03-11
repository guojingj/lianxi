package com.example.demo.subject.service.impl;

import com.example.demo.platform.mybatis.dao.BaseDao;
import com.example.demo.platform.mybatis.service.BaseServiceImpl;
import com.example.demo.subject.entity.Subject;
import com.example.demo.subject.repository.SubjectDao;
import com.example.demo.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SubjectServiceImpl extends BaseServiceImpl<Subject,Long> implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;
    @Override
    public BaseDao<Subject, Long> getDao() {
        return null;
    }

    //查询所有
    @Override
    public List<Subject> queryAll(Subject subject) {
        return subjectDao.queryAll(subject);
    }

    //新增
    @Override
    public void addQuestion(Subject subject) {
        subjectDao.addQuestion(subject);
    }

    //批量删除
    @Override
    public void batchDelete(String ids) {
        subjectDao.batchDelete(ids);
    }
}
