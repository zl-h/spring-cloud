package com.shenghe.index.middleware.service;


import com.shenghe.index.common.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/5/20.
 */
public interface UserService {

/*    void test();*/

    //通过map来查询，一个查询全部搞定
    //对于特殊的查询来说（不知道具体传什么参数，最多支持三个参数，三个值，三个比较方式），有一个单独的接口，以便扩展
/*    List<User> getUserList(Map<String,Object> map);*/

/*    *//**
     * 根据sessionId得到session
     *//*
    HttpSession getSesionBySessionId(String sessionId);

    *//**
     * 强制更新session
     *//*
    void updateSession(String sessionId);

    *//**
     *登陆成功后保存session
     *//*
    void saveSession(HttpSession session);*/


    List<User> getDataList(Map<String, Object> map);

    Long getDataListCount(Map<String, Object> map);

    Integer setData(Map<String, Object> map);

    Integer removeData(Map<String, Object> map);

    Long addData(Map<String, Object> map);

    String userListToString(List<User> userList);

    //重置用户用户组的值
    void reset();



}
