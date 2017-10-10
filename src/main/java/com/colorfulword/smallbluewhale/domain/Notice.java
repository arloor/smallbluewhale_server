package com.colorfulword.smallbluewhale.domain;

import java.sql.Timestamp;

/**
 *   `notice_id` INT NOT NULL AUTO_INCREMENT,
 `notice_title` TEXT NULL COMMENT '标题',
 `notice_content` TEXT NULL COMMENT '内容',
 `notice_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
 `notice_to_building_id` INT NULL COMMENT '发送到楼栋',
 `notice_to_study_info_id`INT NOT NULL COMMENT '发送到院系',
 `notice_to_dorm_id` INT NULL COMMENT '发送到宿舍',
 `notice_to_user_id` INT NULL COMMENT '发送到用户',
 * 通知
 * Created by jone.sun on 2017/8/10.
 */
public class Notice {
    private Integer noticeId;
    private String noticeTitle; //标题
    private String noticeContent; //内容
    private Timestamp noticeTime; //发布时间
    private Integer noticeToBuildingId; //发送到楼栋
    private Integer noticeToStudyInfoId; //发送到院系
    private Integer noticeToDormId; //发送到宿舍
    private Integer noticeToUserId; //发送到用户

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Timestamp getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Timestamp noticeTime) {
        this.noticeTime = noticeTime;
    }

    public Integer getNoticeToBuildingId() {
        return noticeToBuildingId;
    }

    public void setNoticeToBuildingId(Integer noticeToBuildingId) {
        this.noticeToBuildingId = noticeToBuildingId;
    }

    public Integer getNoticeToStudyInfoId() {
        return noticeToStudyInfoId;
    }

    public void setNoticeToStudyInfoId(Integer noticeToStudyInfoId) {
        this.noticeToStudyInfoId = noticeToStudyInfoId;
    }

    public Integer getNoticeToDormId() {
        return noticeToDormId;
    }

    public void setNoticeToDormId(Integer noticeToDormId) {
        this.noticeToDormId = noticeToDormId;
    }

    public Integer getNoticeToUserId() {
        return noticeToUserId;
    }

    public void setNoticeToUserId(Integer noticeToUserId) {
        this.noticeToUserId = noticeToUserId;
    }
}
