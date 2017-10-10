package com.colorfulword.smallbluewhale.domain;

/**
 * 校园活动
 * Created by jone.sun on 2017/8/8.
 */
public class CampusActivity {

    private Integer campusActivityId;
    private String campusActivityName; //活动名称
    private String campusActivityDetail; //活动详情
    private String campusActivityCampus; //所属校区

    private String campusActivityTime; //活动时间
    private Integer campusActivityStatus; //当前状态 0 进行中 -1 已过期
    private String pics; //图片地址

    public Integer getCampusActivityId() {
        return campusActivityId;
    }

    public void setCampusActivityId(Integer campusActivityId) {
        this.campusActivityId = campusActivityId;
    }

    public String getCampusActivityName() {
        return campusActivityName;
    }

    public void setCampusActivityName(String campusActivityName) {
        this.campusActivityName = campusActivityName;
    }

    public String getCampusActivityDetail() {
        return campusActivityDetail;
    }

    public void setCampusActivityDetail(String campusActivityDetail) {
        this.campusActivityDetail = campusActivityDetail;
    }

    public String getCampusActivityCampus() {
        return campusActivityCampus;
    }

    public void setCampusActivityCampus(String campusActivityCampus) {
        this.campusActivityCampus = campusActivityCampus;
    }

    public String getCampusActivityTime() {
        return campusActivityTime;
    }

    public void setCampusActivityTime(String campusActivityTime) {
        this.campusActivityTime = campusActivityTime;
    }

    public Integer getCampusActivityStatus() {
        return campusActivityStatus;
    }

    public void setCampusActivityStatus(Integer campusActivityStatus) {
        this.campusActivityStatus = campusActivityStatus;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }
}
