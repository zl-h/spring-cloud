package com.shenghe.index.middleware.mapper;


import com.shenghe.index.common.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/5/23.
 */
@Mapper
public interface UserMapper {

    List<User> getDataList(Map<String, Object> map);

    Long getDataListCount(Map<String, Object> map);


    /**
     * 数据修改接口
     * @param map
     * @return
     */
    Integer setData(Map<String, Object> map);

    Integer removeData(Map<String, Object> map);

    Long addData(Map<String, Object> map);

    List<User> getAllIdShowGroupsList(Map<String, Object> map);

    Integer setAllIdShowGroupList(Map<String, Object> map);

}
