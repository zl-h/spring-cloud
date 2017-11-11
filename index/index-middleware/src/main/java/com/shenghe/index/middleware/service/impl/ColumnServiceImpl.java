package com.shenghe.index.middleware.service.impl;

import com.shenghe.index.common.antdEntity.AntdColumn;
import com.shenghe.index.middleware.mapper.ColumnMapper;
import com.shenghe.index.middleware.service.ColumnService;
import org.apache.ibatis.ognl.IntHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/10/22.
 */

@Service
public class ColumnServiceImpl implements ColumnService{

    @Autowired
    ColumnMapper columnMapper;

    @Override
    public List<AntdColumn> getColumns(String systemName, String modualName, Long languageId) {
        Map<String,Object> map = new HashMap();
        map.put("systemName",systemName);
        map.put("modualName",modualName);
        map.put("languageId",languageId);
        return columnMapper.getColumns(map);
    }
}
