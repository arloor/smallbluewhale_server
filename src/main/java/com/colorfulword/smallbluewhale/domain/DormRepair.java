package com.colorfulword.smallbluewhale.domain;

import java.sql.Timestamp;

/**
 * 宿舍报修
 * Created by jone.sun on 2017/8/10.
 */
public class DormRepair {

    private Integer repairId;
    private Integer repairUserId; //报修人
    private Timestamp repairTime; //报修时间
    private Integer repairSchoolBuildingId; //所在地点-楼栋
    private Integer repairDormId; //所在地点-宿舍
    private String articleName; //损坏物品
    private String reason; //损坏原因
    private String desc; //损坏描述
    private String pics;//图片
    private Integer repairStatus; //报修状态 0未查看和1已确认
    private String dormRepairReply; //报修反馈

    private SchoolDorm schoolDorm; //显示用-宿舍号

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public Integer getRepairUserId() {
        return repairUserId;
    }

    public void setRepairUserId(Integer repairUserId) {
        this.repairUserId = repairUserId;
    }

    public Timestamp getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Timestamp repairTime) {
        this.repairTime = repairTime;
    }

    public Integer getRepairSchoolBuildingId() {
        return repairSchoolBuildingId;
    }

    public void setRepairSchoolBuildingId(Integer repairSchoolBuildingId) {
        this.repairSchoolBuildingId = repairSchoolBuildingId;
    }

    public Integer getRepairDormId() {
        return repairDormId;
    }

    public void setRepairDormId(Integer repairDormId) {
        this.repairDormId = repairDormId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public Integer getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(Integer repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getDormRepairReply() {
        return dormRepairReply;
    }

    public void setDormRepairReply(String dormRepairReply) {
        this.dormRepairReply = dormRepairReply;
    }

    public SchoolDorm getSchoolDorm() {
        return schoolDorm;
    }

    public void setSchoolDorm(SchoolDorm schoolDorm) {
        this.schoolDorm = schoolDorm;
    }
}
