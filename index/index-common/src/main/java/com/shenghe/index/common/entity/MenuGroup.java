package com.shenghe.index.common.entity;


import com.shenghe.common.entity.BaseEntity;

import java.util.List;

/**
 * Created by zl-h on 2017/5/25.
 * 二级菜单
 */
public class MenuGroup extends BaseEntity {

    private  Menu menu;

    private List<Menu> childMenuList;

    private int haveChild;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getChildMenuList() {
        return childMenuList;
    }

    public void setChildMenuList(List<Menu> childMenuList) {
        this.childMenuList = childMenuList;
    }

    public int getHaveChild() {
        return haveChild;
    }

    public void setHaveChild(int haveChild) {
        this.haveChild = haveChild;
    }
}
