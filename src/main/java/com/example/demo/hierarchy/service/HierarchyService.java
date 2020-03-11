package com.example.demo.hierarchy.service;

import com.example.demo.hierarchy.entity.Hierarchy;
import com.example.demo.platform.mybatis.service.BaseService;

import java.util.List;

public interface HierarchyService extends BaseService<Hierarchy,Long>{

    void edit(Hierarchy hierarchy);

    //批量查询
    List<Hierarchy> batchQuery(String ids);

    //批量删除
    void batchDelete(String ids);
    //查询所有
    List<Hierarchy> queryAll();
}
