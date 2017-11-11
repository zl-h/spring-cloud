package com.shenghe.common.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by zl-h on 2017/5/22.
 */
public class BaseEntity implements Serializable{

    /**
     * 实体类标记
     */
    private Integer baseEntityFlag;

    public Integer getBaseEntityFlag() {
        return baseEntityFlag;
    }

    public void setBaseEntityFlag(Integer baseEntityFlag) {
        this.baseEntityFlag = baseEntityFlag;
    }

    public String toJsonString(){
        return JSON.toJSONString(this);
    }
}
