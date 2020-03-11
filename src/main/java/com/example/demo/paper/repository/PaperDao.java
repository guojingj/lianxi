package com.example.demo.paper.repository;

import com.example.demo.paper.entity.Paper;
import com.example.demo.platform.mybatis.dao.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperDao extends BaseDao<Paper,Long> {
}
