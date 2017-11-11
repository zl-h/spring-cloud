package com.shenghe.index.middleware.service.impl;

import com.shenghe.index.common.entity.AuthorityMenuGroup;
import com.shenghe.index.middleware.mapper.AuthorityMenuGroupMapper;
import com.shenghe.index.middleware.service.AuthorityMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/7/2.
 */
@Service(value = "authorityMenuGroupService")
public class AuthorityMenuGroupServiceImpl implements AuthorityMenuGroupService {

    @Autowired
    AuthorityMenuGroupMapper authorityMenuGroupMapper;

    @Override
    public List<AuthorityMenuGroup> getDataList(Map<String, Object> map) {
        return authorityMenuGroupMapper.getDataList(map);
    }

    @Override
    public Integer setData(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer removeData(Map<String, Object> map) {
        return authorityMenuGroupMapper.removeData(map);
    }

    @Override
    public Integer addData(Map<String, Object> map) {
        return authorityMenuGroupMapper.addData(map);
    }

    @Override
    public Integer updateMenuUserGroupAuthority(Long menuId, String showGroups) {
        //此处需要做事务控制
        Map<String,Object> map = new HashMap<>();
        map.put("menuId",menuId);
        Integer integer = removeData(map);
        String[] groups= showGroups.split(",");
        if(groups.length == 0){
            return 0;
        }
        List<AuthorityMenuGroup> authorityMenuGroups = new ArrayList<>();
        for(int i = 0;i< groups.length;i ++){
            AuthorityMenuGroup authorityMenuGroup = new AuthorityMenuGroup();
            authorityMenuGroup.setMenuId(menuId);
            authorityMenuGroup.setGroupId(Long.valueOf(groups[i]));
            authorityMenuGroups.add(authorityMenuGroup);
        }
        Map<String,Object> mapList = new HashMap<>();
        mapList.put("list",authorityMenuGroups);
        Integer count = addData(mapList);
        return count;
    }

    @Override
    public Integer updateMenuUserGroupAuthorityByGroupId(Long groupId, String showMenus) {
        //此处需要做事务控制
        Map<String,Object> map = new HashMap<>();
        map.put("groupId",groupId);
        Integer integer = removeData(map);
        String[] menus= showMenus.split(",");
        if(menus.length == 0){
            return 0;
        }
        List<AuthorityMenuGroup> authorityMenuGroups = new ArrayList<>();
        for(int i = 0;i< menus.length;i ++){
            AuthorityMenuGroup authorityMenuGroup = new AuthorityMenuGroup();
            authorityMenuGroup.setMenuId(Long.valueOf(menus[i]));
            authorityMenuGroup.setGroupId(groupId);
            authorityMenuGroups.add(authorityMenuGroup);
        }
        Map<String,Object> mapList = new HashMap<>();
        mapList.put("list",authorityMenuGroups);
        Integer count = addData(mapList);
        return count;
    }
}
