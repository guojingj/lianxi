package com.example.demo.hierarchy.service.impl;

import com.example.demo.hierarchy.entity.Hierarchy;
import com.example.demo.platform.mybatis.dao.BaseDao;
import com.example.demo.platform.mybatis.service.BaseServiceImpl;
import com.example.demo.hierarchy.repository.HierarchyDao;
import com.example.demo.hierarchy.service.HierarchyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HierarchyServiceImpl extends BaseServiceImpl<Hierarchy,Long> implements HierarchyService{

    @Autowired
    private HierarchyDao hierarchyDao;

    @Override
    public BaseDao<Hierarchy, Long> getDao() {
        return hierarchyDao;
    }

    @Override
    public void edit(Hierarchy hierarchy) {

        if (null != hierarchy.getId()){
            hierarchyDao.updateByPrimaryKeySelective(hierarchy);
        }else {
            Long parentId = hierarchy.getParentId();
            if (!"0".equals(String.valueOf(parentId))){
                Hierarchy hierarchy1 = hierarchyDao.selectByPrimaryKey(parentId);
                String fpids = hierarchy1.getPids();
                hierarchy.setPids(fpids+","+parentId);

            }else {
                hierarchy.setPids("0");
            }
            hierarchyDao.insertSelective(hierarchy);

        }

    }
    //批量查询
    @Override
    public List<Hierarchy> batchQuery(String ids) {
        return hierarchyDao.batchQuery(ids);
    }
    //批量删除
    @Override
    public void batchDelete(String ids) {
        hierarchyDao.batchDelete(ids);
    }
    //查询所有
    @Override
    public List<Hierarchy> queryAll() {
        List<Hierarchy> list = hierarchyDao.queryAll();
        return buildByRecursive(list);
    }
    private  List<Hierarchy> buildByRecursive(List<Hierarchy> treeNodes) {
        List<Hierarchy> trees = new ArrayList<Hierarchy>();
        for (Hierarchy treeNode : treeNodes) {
            if ("0".equals(String.valueOf(treeNode.getParentId()))) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }
    /**
     * 递归查找子节点
     */
    private Hierarchy findChildren(Hierarchy treeNode, List<Hierarchy> treeNodes) {
        for (Hierarchy it : treeNodes) {
            if (treeNode.getId().equals(it.getParentId())) {
                if (treeNode.getNodes() == null) {
                    treeNode.setNodes(new ArrayList<Hierarchy>());
                }
                treeNode.getNodes().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
