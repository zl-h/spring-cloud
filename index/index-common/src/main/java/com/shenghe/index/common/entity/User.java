package com.shenghe.index.common.entity;

import com.shenghe.common.entity.BaseEntity;

import java.util.Date;

/**
 * Created by zl-h on 2017/5/20.
 */
public class User extends BaseEntity {

    private Long id;

    private  String userName;

    private  String trueName;

    private String password;

    private Date createTime;

    private String defaultLang;

    private Long defaultLangId;

    private Long createUserId;

    /**
     * 用户对于的用户组，仅仅用于展示
     */

    private String showGroups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDefaultLang() {
        return defaultLang;
    }

    public void setDefaultLang(String defaultLang) {
        this.defaultLang = defaultLang;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getShowGroups() {
        return showGroups;
    }

    public void setShowGroups(String showGroups) {
        this.showGroups = showGroups;
    }

    public Long getDefaultLangId() {
        return defaultLangId;
    }

    public void setDefaultLangId(Long defaultLangId) {
        this.defaultLangId = defaultLangId;
    }
}
