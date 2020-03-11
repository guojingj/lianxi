package com.example.demo.subject.controller;

import com.example.demo.subject.entity.Subject;
import com.example.demo.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    //查询所有
    @RequestMapping("/selAll")
    public List<Subject> selAll(Subject subject){
        return subjectService.queryAll(subject);
    }

    //新增
    @RequestMapping("/addData")
    public void addData(Subject subject){
        subjectService.addQuestion(subject);
    }

    //批量删除
    @RequestMapping("/batchDeletes")
    public void batchDeletes(String ids){
        subjectService.batchDelete(ids);
    }
}
