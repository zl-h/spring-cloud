package com.shenghe.index.middleware.service;


import com.shenghe.index.common.entity.AuthorityMenuGroup;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/7/2.
 */
public interface AuthorityMenuGroupService {

    /**
     * 获取用户菜单，将菜单放在session里
     * @return
     */
    List<AuthorityMenuGroup> getDataList(Map<String, Object> map);

    Integer setData(Map<String, Object> map);

    Integer removeData(Map<String, Object> map);

    Integer addData(Map<String, Object> map);

    Integer updateMenuUserGroupAuthority(Long menuId, String showGroups);

    Integer updateMenuUserGroupAuthorityByGroupId(Long groupId, String showMenus);

}
