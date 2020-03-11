package com.example.demo.hierarchy.entity;


import lombok.Data;

import java.util.List;
@Data
public class Hierarchy {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 知识体系分类名称
     */
    private String text;


    /**
     * 题库类型 0（公共题库/部门题库）1（其他题库）
     */
    private Integer subjectType;
    /**
     * 父id
     */
    private Long parentId;

    /**
     * 父节点名字
     */
    private String parentName;

    /**
     * 所有父节点id
     */
    private String pids;

    /**
     * 子分类
     */
    private List<Hierarchy> nodes;

    /**
     * 创建人id
     */
    private String creatorId;

    /**
     * 域id
     */
    private String domainId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Integer subjectType) {
        this.subjectType = subjectType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public List<Hierarchy> getNodes() {
        return nodes;
    }

    public void setNodes(List<Hierarchy> nodes) {
        this.nodes = nodes;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }
}
