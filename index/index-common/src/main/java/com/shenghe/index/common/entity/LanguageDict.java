package com.shenghe.index.common.entity;

import com.shenghe.common.entity.BaseEntity;

/**
 * Created by zl-h on 2017/7/7.
 * 语言字典
 */
public class LanguageDict extends BaseEntity {

    private Long id;

    private String dictCode;

    private String dictValue;

    private Long userLanguageId;

    private String projectName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public Long getUserLanguageId() {
        return userLanguageId;
    }

    public void setUserLanguageId(Long userLanguageId) {
        this.userLanguageId = userLanguageId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
