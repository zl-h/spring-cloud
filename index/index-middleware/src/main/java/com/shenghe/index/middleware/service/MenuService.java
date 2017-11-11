package com.shenghe.index.middleware.service;


import com.shenghe.index.common.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/5/25.
 */
public interface MenuService {

    /**
     * 获取用户菜单，将菜单放在session里
     * @return
     */
/*    List<Menu> getMenuList(Map<String,Object> map);*/

    /**
     * 由于语言问题，将菜单对应的列名放在数据库里
     * 数据库里存放展示的表格数据和表头，表头分语言
     *
     * 动态的配置在数据库
     * 非动态的写在class里面
     */
    List<Menu> getDataList(Map<String, Object> map);

    Long getDataListCount(Map<String, Object> map);

    Integer setData(Map<String, Object> map);

    Integer removeData(Map<String, Object> map);

    Long addData(Map<String, Object> map);

    String menuListToString(List<Menu> menuList);

    //重置用户用户组的值
    void reset();


}
