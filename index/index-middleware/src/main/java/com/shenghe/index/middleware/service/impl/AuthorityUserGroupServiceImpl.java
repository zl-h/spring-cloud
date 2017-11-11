package com.shenghe.index.middleware.service.impl;


import com.shenghe.index.common.entity.AuthorityUserGroup;
import com.shenghe.index.middleware.mapper.AuthorityUserGroupMapper;
import com.shenghe.index.middleware.service.AuthorityUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/7/2.
 */
@Service(value = "authorityUserGroupService")
public class AuthorityUserGroupServiceImpl implements AuthorityUserGroupService {

    @Autowired
    AuthorityUserGroupMapper authorityUserGroupMapper;

    @Override
    public List<AuthorityUserGroup> getDataList(Map<String, Object> map) {
        return authorityUserGroupMapper.getDataList(map);
    }

    @Override
    public Integer setData(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer removeData(Map<String, Object> map) {
        return authorityUserGroupMapper.removeData(map);
    }

    @Override
    public Integer addData(Map<String, Object> map) {
        return authorityUserGroupMapper.addData(map);
    }

    @Override
    public Integer updateUserUserGroupAuthority(Long userId, String showGroups) {
        //此处需要做事务控制
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        Integer integer = removeData(map);
        String[] groups= showGroups.split(",");
        if(groups.length == 0){
            return 0;
        }
        List<AuthorityUserGroup> authorityUserGroups = new ArrayList<>();
        for(int i = 0;i< groups.length;i ++){
            AuthorityUserGroup authorityUserGroup = new AuthorityUserGroup();
            authorityUserGroup.setUserId(userId);
            authorityUserGroup.setGroupId(Long.valueOf(groups[i]));
            authorityUserGroups.add(authorityUserGroup);
        }
        Map<String,Object> mapList = new HashMap<>();
        mapList.put("list",authorityUserGroups);
        Integer count = addData(mapList);
        return count;
    }

    @Override
    public Integer updateUserUserGroupAuthorityByGroupId(Long groupId, String showUsers) {
        Map<String,Object> map = new HashMap<>();
        map.put("groupId",groupId);
        Integer integer = removeData(map);
        String[] users= showUsers.split(",");
        if(users.length == 0){
            return 0;
        }
        List<AuthorityUserGroup> authorityUserGroups = new ArrayList<>();
        for(int i = 0;i< users.length;i ++){
            AuthorityUserGroup authorityUserGroup = new AuthorityUserGroup();
            authorityUserGroup.setUserId(Long.valueOf(users[i]));
            authorityUserGroup.setGroupId(groupId);
            authorityUserGroups.add(authorityUserGroup);
        }
        Map<String,Object> mapList = new HashMap<>();
        mapList.put("list",authorityUserGroups);
        Integer count = addData(mapList);
        return count;
    }

}
