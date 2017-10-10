package com.colorfulword.smallbluewhale.domain;

import java.sql.Timestamp;
import java.util.List;

/**
 * 校园纪事
 * Created by jone.sun on 2017/8/8.
 */
public class CampusRecordEvent {

    private Integer recordEventId;
    private String title;
    private String recordTime; //纪事时间
    private String campus; //所属校区
    private String organizationSide; //组织方
    private String content; //纪事介绍
    private Integer status;
    private String pics;


    public Integer getRecordEventId() {
        return recordEventId;
    }

    public void setRecordEventId(Integer recordEventId) {
        this.recordEventId = recordEventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getOrganizationSide() {
        return organizationSide;
    }

    public void setOrganizationSide(String organizationSide) {
        this.organizationSide = organizationSide;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }
}
