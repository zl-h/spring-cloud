package com.shenghe.index.common.antdEntity;

import com.alibaba.fastjson.JSONObject;
import com.shenghe.common.entity.BaseEntity;

import java.util.List;

/**
 * Created by zl-h on 2017/10/20.
 */
public class AntdResult<T> extends BaseEntity{

    public static AntdResult getAntdResult(Object data,Long count,List<AntdColumn> columns,JSONObject jsonData){
        AntdResult antdResult = new AntdResult();
        antdResult.setColumns(columns);
        antdResult.setCount(count);
        antdResult.setData(data);
        antdResult.setJsonData(jsonData);
        return antdResult;
    }

    private T data;

    private List<AntdColumn> columns;

    private JSONObject jsonData;

    private Long count;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<AntdColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<AntdColumn> columns) {
        this.columns = columns;
    }

    public JSONObject getJsonData() {
        return jsonData;
    }

    public void setJsonData(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
