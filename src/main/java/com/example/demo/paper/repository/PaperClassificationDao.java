package com.example.demo.paper.repository;

import com.example.demo.paper.entity.PaperClassification;
import com.example.demo.platform.mybatis.dao.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperClassificationDao extends BaseDao<PaperClassification,Long> {

}
