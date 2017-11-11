package com.shenghe.index.middleware.mapper;



import com.shenghe.index.common.entity.AuthorityMenuGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/5/25.
 */
@Mapper
public interface AuthorityMenuGroupMapper {

    List<AuthorityMenuGroup> getDataList(Map<String, Object> map);

    /**
     * 数据修改接口
     * @param map
     * @return
     */
    Integer setData(Map<String, Object> map);

    Integer removeData(Map<String, Object> map);

    Integer addData(Map<String, Object> map);

}
