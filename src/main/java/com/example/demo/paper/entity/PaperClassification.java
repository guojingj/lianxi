package com.example.demo.paper.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class PaperClassification implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 试卷分类名称
     */
    private String text;

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 父节点id
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
    private List<PaperClassification> nodes;

    /**
     * 创建人id
     */
    private String creatorId;

    /**
     * 域id
     */
    private String domainId;

}
