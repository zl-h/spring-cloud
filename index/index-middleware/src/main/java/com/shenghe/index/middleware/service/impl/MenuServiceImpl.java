package com.shenghe.index.middleware.service.impl;

import com.shenghe.index.common.entity.Menu;
import com.shenghe.index.middleware.mapper.MenuMapper;
import com.shenghe.index.middleware.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/5/25.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> getDataList(Map<String,Object> map) {
        return menuMapper.getDataList(map);
    }

    @Override
    public Integer setData(Map<String, Object> map) {
        return menuMapper.setData(map);
    }

    @Override
    public Long getDataListCount(Map<String, Object> map) {
        return menuMapper.getDataListCount(map);
    }

    @Override
    public Integer removeData(Map<String, Object> map) {

        return menuMapper.removeData(map);
    }

    @Override
    public Long addData(Map<String, Object> map) {
         menuMapper.addData(map);
         return Long.valueOf(String.valueOf(map.get("id")));
    }

    @Override
    public String menuListToString(List<Menu> menuList) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < menuList.size();i ++){
            stringBuilder.append(menuList.get(i).getMenuName());
            if(i != menuList.size() - 1){
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public void reset() {
        List<Menu> menuList = menuMapper.getAllIdShowGroupsList(null);
        if(menuList.size() == 0){
            return;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("list",menuList);
        menuMapper.setAllIdShowGroupList(map);
    }
}
