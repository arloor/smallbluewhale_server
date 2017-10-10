package com.colorfulword.smallbluewhale.requestbody;

import java.sql.Timestamp;

/**
 * 确认报修反馈
 * Created by jone.sun on 2017/8/10.
 */
public class DormRepairReply {
    private Integer repairId;
    private String dormRepairReply; //报修反馈

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public String getDormRepairReply() {
        return dormRepairReply;
    }

    public void setDormRepairReply(String dormRepairReply) {
        this.dormRepairReply = dormRepairReply;
    }
}
