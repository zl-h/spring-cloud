package com.shenghe.index.common.entity;

import com.shenghe.common.entity.BaseEntity;

/**
 * Created by zl-h on 2017/6/27.
 */
public class Language extends BaseEntity{

    private Long id;

    private String userLanguage;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
