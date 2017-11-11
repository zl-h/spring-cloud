package com.shenghe.index.common.entity;

import com.shenghe.common.entity.BaseEntity;

import java.util.Date;

/**
 * Created by zl-h on 2017/5/22.
 */
public class Menu extends BaseEntity {

    //自增id
    private Long id;

    //菜单名
    private String menuName;

    //菜单指向的jsp页面
    private String menuUrl;

    //父级菜单id
    private Long parentMenu;

    //排序
    private Integer sort;

    //创建用户id
    private Long createUserId;

    //创建时间
    private Date createTime;

    //菜单类型
    private String menuType;

    //菜单对应的索引路径
    private String menuIndex;

    private Long languageId;

    private String languageIdDesc;


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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Long parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(String menuIndex) {
        this.menuIndex = menuIndex;
    }

    public String getShowGroups() {
        return showGroups;
    }

    public void setShowGroups(String showGroups) {
        this.showGroups = showGroups;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getLanguageIdDesc() {
        return languageIdDesc;
    }

    public void setLanguageIdDesc(String languageIdDesc) {
        this.languageIdDesc = languageIdDesc;
    }
}
