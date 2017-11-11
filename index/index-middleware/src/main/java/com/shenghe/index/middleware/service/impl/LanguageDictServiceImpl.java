package com.shenghe.index.middleware.service.impl;

import com.shenghe.index.common.entity.LanguageDict;
import com.shenghe.index.middleware.mapper.LanguageDictMapper;
import com.shenghe.index.middleware.service.LanguageDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/7/7.
 */
@Service
public class LanguageDictServiceImpl implements LanguageDictService {

    @Autowired
    LanguageDictMapper languageDictMapper;

    @Override
    public List<LanguageDict> getDataList(Map<String, Object> map) {
        return languageDictMapper.getDataList(map);
    }

    @Override
    public Integer setData(Map<String, Object> map) {
        return languageDictMapper.setData(map);
    }

    @Override
    public Integer removeData(Map<String, Object> map) {
        return languageDictMapper.removeData(map);
    }

    @Override
    public Integer addData(Map<String, Object> map) {
        return languageDictMapper.addData(map);
    }
}
