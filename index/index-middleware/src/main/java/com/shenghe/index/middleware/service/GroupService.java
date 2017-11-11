package com.shenghe.index.middleware.service;


import com.shenghe.index.common.entity.Group;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/6/22.
 */
public interface GroupService {

    /**
     * 获取用户菜单，将菜单放在session里
     * @return
     */
    List<Group> getDataList(Map<String, Object> map);

    Long getDataListCount(Map<String, Object> map);

    Integer setData(Map<String, Object> map);

    Integer removeData(Map<String, Object> map);

    Long addData(Map<String, Object> map);

    String groupListToString(List<Group> groupList);

    //重置用户用户组的值
    void reset();

}
