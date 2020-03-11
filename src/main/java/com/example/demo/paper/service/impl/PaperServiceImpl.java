package com.example.demo.paper.service.impl;

import com.example.demo.paper.entity.Paper;
import com.example.demo.paper.repository.PaperDao;
import com.example.demo.paper.service.PaperService;
import com.example.demo.platform.mybatis.dao.BaseDao;
import com.example.demo.platform.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperServiceImpl extends BaseServiceImpl<Paper,Long> implements PaperService {
    @Autowired
    private PaperDao paperDao;
    @Override
    public BaseDao<Paper, Long> getDao() {
        return paperDao;
    }
}
