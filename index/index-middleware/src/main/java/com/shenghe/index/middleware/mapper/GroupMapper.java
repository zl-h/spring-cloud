package com.shenghe.index.middleware.mapper;


import com.shenghe.index.common.entity.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/5/25.
 */
@Mapper
public interface GroupMapper {

    /**
     * 获取用户菜单，将菜单放在session里
     * @return
     */
    List<Group> getDataList(Map<String, Object> map);

    Long getDataListCount(Map<String, Object> map);

    /**
     * 数据修改接口
     * @param map
     * @return
     */
    Integer setData(Map<String, Object> map);

    Integer removeData(Map<String, Object> map);

    Long addData(Map<String, Object> map);

    List<Group> getAllIdShowUserMenusList(Map<String, Object> map);

    Integer setAllIdShowUserMenuList(Map<String, Object> map);

}
