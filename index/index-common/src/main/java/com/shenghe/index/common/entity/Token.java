package com.shenghe.index.common.entity;

import com.shenghe.common.entity.BaseEntity;
import org.joda.time.DateTime;

/**
 * Created by zl-h on 2017/6/14.
 */
public class Token extends BaseEntity {

    private String id;

    private DateTime lastAccessTime;

    private DateTime endTime;

    private DateTime startTime;


    private User user;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(DateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
