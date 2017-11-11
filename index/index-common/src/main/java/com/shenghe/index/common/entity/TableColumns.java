package com.shenghe.index.common.entity;

import com.shenghe.common.entity.BaseEntity;

/**
 * Created by zl-h on 2017/6/7.
 */
//存放列名的table
public class TableColumns extends BaseEntity {

    private Long id;

    private String serviceName;

    private String columnsName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getColumnsName() {
        return columnsName;
    }

    public void setColumnsName(String columnsName) {
        this.columnsName = columnsName;
    }
}
