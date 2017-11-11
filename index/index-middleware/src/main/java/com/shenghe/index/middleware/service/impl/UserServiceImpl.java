package com.shenghe.index.middleware.service.impl;


import com.shenghe.index.common.entity.User;
import com.shenghe.index.middleware.mapper.UserMapper;
import com.shenghe.index.middleware.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/5/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public List<User> getDataList(Map<String, Object> map) {
        return userMapper.getDataList(map);
    }

    @Override
    public Long getDataListCount(Map<String, Object> map) {
        return userMapper.getDataListCount(map);
    }

    @Override
    public Integer setData(Map<String, Object> map) {
        return userMapper.setData(map);
    }

    @Override
    public Integer removeData(Map<String, Object> map) {
        return userMapper.removeData(map);
    }

    @Override
    public Long addData(Map<String, Object> map) {
         userMapper.addData(map);
         return Long.valueOf(String.valueOf(map.get("id")));
    }

    @Override
    public String userListToString(List<User> userList) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < userList.size();i ++){
            stringBuilder.append(userList.get(i).getUserName());
            if(i != userList.size() - 1){
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public void reset() {
        List<User> userList = userMapper.getAllIdShowGroupsList(null);
        if(userList.size() == 0){
            return;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("list",userList);
        userMapper.setAllIdShowGroupList(map);
    }
}
