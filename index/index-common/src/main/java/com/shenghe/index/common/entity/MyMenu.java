package com.shenghe.index.common.entity;

import com.shenghe.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl-h on 2017/11/1.
 */
public class MyMenu extends BaseEntity{

    private Menu menu;

    private List<MyMenu> children;


    public void  init(){
        List<MyMenu> myMenuList = new ArrayList<>();

    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<MyMenu> getChildren() {
        return children;
    }

    public void setChildren(List<MyMenu> children) {
        this.children = children;
    }
}
