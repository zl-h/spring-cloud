package com.shenghe.index.common.entity;

import com.shenghe.common.entity.BaseEntity;

import java.util.Date;

/**
 * Created by zl-h on 2017/5/23.
 */
public class Group extends BaseEntity{

    private Long id;

    private String groupName;

    private String showUsers;

    private String showMenus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getShowUsers() {
        return showUsers;
    }

    public void setShowUsers(String showUsers) {
        this.showUsers = showUsers;
    }

    public String getShowMenus() {
        return showMenus;
    }

    public void setShowMenus(String showMenus) {
        this.showMenus = showMenus;
    }
}
