package com.shenghe.index.middleware.mapper;


import com.shenghe.index.common.entity.LanguageDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/7/7.
 */
@Mapper
public interface LanguageDictMapper {

    List<LanguageDict> getDataList(Map<String, Object> map);

    Integer setData(Map<String, Object> map);

    Integer removeData(Map<String, Object> map);

    Integer addData(Map<String, Object> map);
}
