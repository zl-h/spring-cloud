package com.shenghe.index.middleware.service;


import com.shenghe.index.common.entity.AuthorityUserGroup;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/7/2.
 */
public interface AuthorityUserGroupService {

    /**
     * 获取用户菜单，将菜单放在session里
     * @return
     */
    List<AuthorityUserGroup> getDataList(Map<String, Object> map);

    Integer setData(Map<String, Object> map);

    Integer removeData(Map<String, Object> map);

    Integer addData(Map<String, Object> map);

    Integer updateUserUserGroupAuthority(Long userId, String showGroups);

    Integer updateUserUserGroupAuthorityByGroupId(Long groupId, String showUsers);

}
