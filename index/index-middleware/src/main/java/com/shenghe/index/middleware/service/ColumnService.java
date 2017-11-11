package com.shenghe.index.middleware.service;

import com.shenghe.index.common.antdEntity.AntdColumn;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/10/22.
 */
public interface ColumnService {

    List<AntdColumn> getColumns(String systemName, String modualName,Long languageId);

}
