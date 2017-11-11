package com.shenghe.index.common.util;


import com.shenghe.index.common.entity.Menu;
import com.shenghe.index.common.entity.MenuGroup;
import com.shenghe.index.common.entity.MenuGroupGroup;
import com.shenghe.index.common.entity.MyMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl-h on 2017/5/25.
 */
public class MenuUtil {

    public static List<MyMenu> getMyMenuList(List<Menu> menuList){
        List<MyMenu> myMenuList = new ArrayList<>();
        for(int i = 0;i < menuList.size();i ++) {
            if (menuList.get(i).getMenuIndex().contains(".") == false) {
                //一级菜单
                MyMenu myMenu = new MyMenu();
                myMenu.setMenu(menuList.get(i));
                List<Menu> children = getChildMenus(menuList.get(i),menuList);
                List<MyMenu> myMenus = new ArrayList<>();
                for(int i2 = 0;i2 < children.size();i2 ++){
                    MyMenu myMenu1 = new MyMenu();
                    myMenu1.setMenu(children.get(i2));
                    List<Menu> children2 = getChildMenus(children.get(i2),menuList);
                    List<MyMenu> myMenus1 = new ArrayList<>();
                    for(int i3 = 0;i3 < children2.size(); i3 ++){
                        MyMenu myMenu2 = new MyMenu();
                        myMenu2.setMenu(children2.get(i3));
                        List<Menu> children3 = getChildMenus(children2.get(i3),menuList);
                        //暂支持四级菜单
                        List<MyMenu> myMenus2 = new ArrayList<>();
                        for(int i4 = 0; i4 < 0;i4 ++){
                            MyMenu myMenu3 = new MyMenu();
                            myMenu3.setMenu(children3.get(i4));
                            myMenus2.add(myMenu3);
                        }
                        myMenu2.setChildren(myMenus2);
                        myMenus1.add(myMenu2);
                    }
                    myMenu1.setChildren(myMenus1);
                    myMenus.add(myMenu1);
                }
                myMenu.setChildren(myMenus);
                myMenuList.add(myMenu);
            }
        }
        return myMenuList;
    }


    //通过菜单列表查询深度为2的菜单
    public static List<MenuGroup> getMenuGroupListBtMenuList(List<Menu> menuList){
        List<MenuGroup> menuGroups = new ArrayList<>();
        for(int i = 0;i < menuList.size();i ++){
            if(menuList.get(i).getMenuIndex().contains(".") == false){
                MenuGroup menuGroup = new MenuGroup();
                menuGroup.setMenu(menuList.get(i));
                List<Menu> childMenuList = getChildMenus(menuList.get(i),menuList);
                menuGroup.setChildMenuList(childMenuList);
                if(childMenuList.size() > 0){
                    menuGroup.setHaveChild(1);
                }else {
                    menuGroup.setHaveChild(0);
                }
                menuGroups.add(menuGroup);
            }
        }
        return menuGroups;
    }



    //得到该菜单的所有子菜单
    public static List<Menu> getChildMenus(Menu menu,List<Menu> menuList){
        List<Menu> childMenus = new ArrayList<>();
        for(int i = 0;i < menuList.size();i ++){
            Integer endIndex = menuList.get(i).getMenuIndex().lastIndexOf(".");
            if(endIndex == -1){
                continue;
            }
            if(menu.getMenuIndex().equals(menuList.get(i).getMenuIndex().substring(0,endIndex)) == true){
                childMenus.add(menuList.get(i));
            }
        }
        return childMenus;
    }

    //根据菜单id和该用户的所有菜单得到其三级菜单列表
    public static List<MenuGroupGroup> getMenuGroupGroupListBtMenuList(List<Menu> menuList, Long id) {
        Menu menu = null;
        for(int i = 0;i < menuList.size();i ++){
            if(menuList.get(i).getId() == id){
                menu = menuList.get(i);
                break;
            }
        }

        List<MenuGroupGroup> menuGroupGroupList = new ArrayList<>();
        List<Menu> menusDepth1 = getChildMenus(menu,menuList);
        for(int i = 0;i < menusDepth1.size();i ++){
            MenuGroupGroup menuGroupGroup = new MenuGroupGroup();
            List<MenuGroup> menuGroups = new ArrayList<>();
            List<Menu> menusDepth2 = getChildMenus(menusDepth1.get(i),menuList);
            for(int j = 0;j < menusDepth2.size();j ++){
                MenuGroup menuGroup = new MenuGroup();
                List<Menu> menusDepth3 = getChildMenus(menusDepth2.get(j),menuList);
                if(menusDepth3.size() > 0){
                    menuGroup.setHaveChild(1);
                    menuGroup.setChildMenuList(menusDepth3);
                }else {
                    menuGroup.setHaveChild(0);
                }
                menuGroup.setMenu(menusDepth2.get(j));
                menuGroups.add(menuGroup);
            }
            if(menuGroups.size() > 0){
                menuGroupGroup.setMenuGroups(menuGroups);
                menuGroupGroup.setHasChild(1);
            }else {
                menuGroupGroup.setHasChild(0);
            }
            menuGroupGroup.setMenu(menusDepth1.get(i));
            menuGroupGroupList.add(menuGroupGroup);
        }
        return  menuGroupGroupList;
    }
}