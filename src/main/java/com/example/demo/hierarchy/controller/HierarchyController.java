package com.example.demo.hierarchy.controller;

import com.example.demo.hierarchy.entity.Hierarchy;
import com.example.demo.hierarchy.service.HierarchyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hierarchy")
public class HierarchyController {
    @Autowired
    private HierarchyService hierarchyService;
    @RequestMapping("/edit")
    public void edit(Hierarchy hierarchy){
        hierarchyService.edit(hierarchy);
    }

    //批量查询
    @RequestMapping("/batchQuery")
    public List<Hierarchy> batchQuery(String ids){
        return hierarchyService.batchQuery(ids);
    }

    //批量删除
    @RequestMapping("/batchDelete")
    public  void  batchDelete(String ids){
        hierarchyService.batchDelete(ids);
    }
    //查询所有
    @RequestMapping("/queryAll")
    public List<Hierarchy> queryAll(){
        return hierarchyService.queryAll();
    }
}
