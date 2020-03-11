package com.example.demo.paper.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Paper implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 试卷名称
     */
    private String text;

    /**
     * 试卷分类id
     */
    private Long paperClassificationId;

    /**
     * 试卷分类名称
     */
    private String paperClassificationName;

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 试卷描述
     */
    private String description;

    /**
     * 每道题的分值
     */
    private String score;

    /**
     * 题目总数
     */
    private Integer count;

    /**
     * 0 此试卷未开放考试 1 已开放考试 默认为0
     */
    private Integer status;

    /**
     * 试卷总分
     */
    private Integer totalGrade;

    /**
     * 及格分数
     */
    private Integer passGrade;

    /**
     * 试卷使用次数
     */
    private Integer usedNum;

    /**
     * 创建人id
     */
    private String creatorId;

    /**
     * 创建人姓名
     */
    private String creatorName;

    /**
     * 域id
     */
    private String domainId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 题目的主键Id，多个以逗号分隔
     */
    private String subjectIds;

    /**
     * 试卷总题目数
     */
    private Integer totalCount;

    /**
     * 考试次数
     */
    private Integer examNum;
}
