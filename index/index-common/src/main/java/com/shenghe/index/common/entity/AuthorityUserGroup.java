package com.shenghe.index.common.entity;

import com.shenghe.common.entity.BaseEntity;

/**
 * Created by zl-h on 2017/7/2.
 */
public class AuthorityUserGroup extends BaseEntity{

    private Long id;

    private Long userId;

    private Long groupId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
