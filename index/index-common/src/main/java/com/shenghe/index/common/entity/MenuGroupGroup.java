package com.shenghe.index.common.entity;


import com.shenghe.common.entity.BaseEntity;

import java.util.List;

/**
 * Created by zl-h on 2017/5/26.
 * 三级菜单
 */
public class MenuGroupGroup extends BaseEntity {

    private Menu menu;

    private List<MenuGroup> menuGroups;

    private Integer hasChild;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<MenuGroup> getMenuGroups() {
        return menuGroups;
    }

    public void setMenuGroups(List<MenuGroup> menuGroups) {
        this.menuGroups = menuGroups;
    }

    public Integer getHasChild() {
        return hasChild;
    }

    public void setHasChild(Integer hasChild) {
        this.hasChild = hasChild;
    }
}
