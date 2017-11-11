package com.shenghe.index.middleware.service;


import com.shenghe.index.common.entity.LanguageDict;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/7/7.
 */
public interface LanguageDictService {

    List<LanguageDict> getDataList(Map<String, Object> map);

    Integer setData(Map<String, Object> map);

    Integer removeData(Map<String, Object> map);

    Integer addData(Map<String, Object> map);
}
