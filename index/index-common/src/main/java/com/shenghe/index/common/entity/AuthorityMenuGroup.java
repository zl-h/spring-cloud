package com.shenghe.index.common.entity;

import com.shenghe.common.entity.BaseEntity;

/**
 * Created by zl-h on 2017/7/2.
 */
public class AuthorityMenuGroup extends BaseEntity{

    private Long id;

    private Long menuId;

    private Long groupId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
