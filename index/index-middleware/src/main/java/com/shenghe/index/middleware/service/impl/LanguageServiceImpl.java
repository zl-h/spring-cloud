package com.shenghe.index.middleware.service.impl;

import com.shenghe.index.common.entity.Language;
import com.shenghe.index.middleware.mapper.LanguageMapper;
import com.shenghe.index.middleware.service.LanguageService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/10/23.
 */
@Service
public class LanguageServiceImpl implements LanguageService{

    @Autowired
    LanguageMapper languageMapper;

    @Override
    public List<Language> getDataList(Map<String, Object> map) {
        return languageMapper.getDataList(map);
    }

    @Override
    public Long getDataListCount(Map<String, Object> map) {
        return languageMapper.getDataListCount(map);
    }

    @Override
    public Integer setData(Map<String, Object> map) {
        return languageMapper.setData(map);
    }

    @Override
    public Integer removeData(Map<String, Object> map) {
        return languageMapper.removeData(map);
    }

    @Override
    public Integer addData(Map<String, Object> map) {
        return languageMapper.addData(map);
    }
}
