package com.shenghe.index.middleware.service.impl;

import com.shenghe.index.common.entity.Group;
import com.shenghe.index.middleware.mapper.GroupMapper;
import com.shenghe.index.middleware.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/6/22.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupMapper groupMapper;

    @Override
    public List<Group> getDataList(Map<String, Object> map) {
        return groupMapper.getDataList(map);
    }

    @Override
    public Long getDataListCount(Map<String, Object> map) {
        return groupMapper.getDataListCount(map);
    }

    @Override
    public Integer setData(Map<String, Object> map) {
        return groupMapper.setData(map);
    }

    @Override
    public Integer removeData(Map<String, Object> map) {
        return groupMapper.removeData(map);
    }

    @Override
    public Long addData(Map<String, Object> map) {
         groupMapper.addData(map);
         return Long.valueOf(String.valueOf(map.get("id")));
    }

    @Override
    public String groupListToString(List<Group> groupList) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < groupList.size();i ++){
            stringBuilder.append(groupList.get(i).getGroupName());
            if(i != groupList.size() - 1){
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public void reset() {
        List<Group> groupList = groupMapper.getAllIdShowUserMenusList(null);
        if(groupList.size() == 0){
            return;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("list",groupList);
        groupMapper.setAllIdShowUserMenuList(map);
    }
}
