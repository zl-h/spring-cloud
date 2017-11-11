package com.shenghe.index.middleware.mapper;

import com.shenghe.index.common.antdEntity.AntdColumn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by zl-h on 2017/10/22.
 */
@Mapper
public interface ColumnMapper {

    List<AntdColumn> getColumns(Map<String,Object> map);

}
