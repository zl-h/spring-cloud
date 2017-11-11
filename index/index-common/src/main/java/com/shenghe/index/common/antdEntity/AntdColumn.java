package com.shenghe.index.common.antdEntity;

import com.shenghe.common.entity.BaseEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by zl-h on 2017/10/19.
 * 蚂蚁金服antd表格的列定义
 * 系统某些模块展示表格的列。跟实际的数据库没有关系
 */
public class AntdColumn extends BaseEntity{

    private Long id;

    /**
     * 列名(展示)
     */
    private String title;

    /**
     * 列标识
     */
    private String dataIndex;

    /**
     * 列宽
     */
    private String width;

    /**
     * 组件类型/**
     * type 1 text  默认
     * type 2 select
     * type 3 multiSelect
     * type 4 datetime
     * typo 5 date
     */
    private Integer componentType;

    /**
     * 当有select的组建时，需要把列表传过去，可能有多个列表，这个是列表的key
     */
    private String listKey;

    /**
     * listKey对应列表发的key
     */
    private String dataKey;

    /**
     * listKey对应列表发的value
     */
    private String valueKey;

    /**
     * 系统名
     */
    private String systemName;

    /**
     * 模块名
     */
    private String modualName;


    /**
     * 菜单所属语言
     */
    private Long languageId;

    /**
     * 列排序
     */
    private Integer order;

    private Boolean editable;

    /**
     * 列操作对应的响应
     */
    private String action;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Integer getComponentType() {
        return componentType;
    }

    public void setComponentType(Integer componentType) {
        this.componentType = componentType;
    }

    public String getListKey() {
        return listKey;
    }

    public void setListKey(String listKey) {
        this.listKey = listKey;
    }

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    public String getValueKey() {
        return valueKey;
    }

    public void setValueKey(String valueKey) {
        this.valueKey = valueKey;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getModualName() {
        return modualName;
    }

    public void setModualName(String modualName) {
        this.modualName = modualName;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(String dataIndex) {
        this.dataIndex = dataIndex;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}