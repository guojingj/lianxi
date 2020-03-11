package com.example.demo.hierarchy.repository;

import com.example.demo.hierarchy.entity.Hierarchy;
import com.example.demo.platform.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HierarchyDao extends BaseDao<Hierarchy,Long>{
     //批量查询
     List<Hierarchy> batchQuery(String ids);
     //批量删除
     void batchDelete(@Param("ids") String ids);
    //查询所有
    List<Hierarchy> queryAll();

}
