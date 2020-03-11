package com.example.demo.subject.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class Subject implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 题目类型 1单选 2多选 3判断 4填空 5问答
     */
    private Integer type;

    /**
     * 题干
     */
    private String question;

    /**
     * 图片（多个用逗号分隔）
     */
    private String images;

    /**
     * 知识体系分类id
     */
    private Long hierarchyClassificationId;

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 知识体系名称

     */
    private String text;

    /**
     * 是否公开 0 不公开 1 公开
     */
    private Integer isPublic;

    /**
     * 是否是备份的题目 0否 1是 默认0
     */
    private Integer isCopy;


    /**
     * 是否是公共题库 0 否（项目部门） 1 是（丽岛物业）
     */
    private Integer isPublicSubject;

    /**
     * 题库类型 0（公共题库/部门题库）1（其他题库）
     */
    private Integer subjectType;


    /**

     * 正确答案（多个用逗号分隔）判断题 0 否 1 是
     */
    private String answer;

    /***
     * 题目类型名称 1单选 2多选 3判断 4填空 5问答
     */
    private String typeName;

    /***
     * 类型集合
     */
    private String typeList;

//    /***
//     * 填空题题干或者选择题选项集合
//     */
//    private List<OptionDetail> optionDetail;

    /**
     * 创建人id
     */
    private String creatorId;

    /**
     * 域id
     */
    private String domainId;

}
