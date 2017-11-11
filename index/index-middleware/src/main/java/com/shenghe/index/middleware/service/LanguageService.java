package com.shenghe.index.middleware.service;

import com.shenghe.index.common.entity.Language;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/6/22.
 *
 * 像这种传参理论上应该传具体的参数，而不是map
 * 为了与之前的系统迅速集成，而且目前是一个人开发，还好
 */
public interface LanguageService {

    List<Language> getDataList(Map<String, Object> map);

    Long getDataListCount(Map<String, Object> map);

    Integer setData(Map<String, Object> map);

    Integer removeData(Map<String, Object> map);

    Integer addData(Map<String, Object> map);

}
