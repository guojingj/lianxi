package com.example.demo.paper.service.impl;

import com.example.demo.hierarchy.entity.Hierarchy;
import com.example.demo.paper.entity.PaperClassification;
import com.example.demo.paper.repository.PaperClassificationDao;
import com.example.demo.paper.service.PaperClassificationService;
import com.example.demo.platform.mybatis.dao.BaseDao;
import com.example.demo.platform.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperClassificationServiceImpl extends BaseServiceImpl<PaperClassification,Long> implements PaperClassificationService{

    @Autowired
    private PaperClassificationDao paperClassificationDao;

    @Override
    public void edit(PaperClassification paperClassification) {

        if (null != paperClassification.getId()){
            paperClassificationDao.updateByPrimaryKeySelective(paperClassification);
        }else {
            Long parentId = paperClassification.getParentId();
            if (!"0".equals(String.valueOf(parentId))){
                PaperClassification paperClassification1 = paperClassificationDao.selectByPrimaryKey(parentId);
                String fpids = paperClassification1.getPids();
                paperClassification.setPids(fpids+","+parentId);

            }else {
                paperClassification.setPids("0");
            }
            paperClassificationDao.insertSelective(paperClassification);

        }
    }

    @Override
    public BaseDao<PaperClassification, Long> getDao() {
        return paperClassificationDao;
    }
}
