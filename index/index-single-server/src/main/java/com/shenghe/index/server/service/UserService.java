package com.shenghe.index.server.service;

import com.shenghe.index.common.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/8/17.
 */
public interface UserService {

     List<User> getDataList(Map<String, Object> map);

     Integer setData(Map<String, Object> map);

     Integer removeData(Map<String, Object> map);

     Long addData(Map<String, Object> map) ;

     String userListToString(List<User> userList) ;

     void reset();
}
