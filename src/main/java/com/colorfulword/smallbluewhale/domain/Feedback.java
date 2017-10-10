package com.colorfulword.smallbluewhale.domain;

import java.sql.Timestamp;

/**
 * 意见反馈
 * Created by jone.sun on 2017/8/9.
 */
public class Feedback {
    private Integer feedbackId;
    private String feedbackQuestion; //问题
    private String feedbackType; //投诉；建议；赞赏
    private String feedbackContent; //意见描述
    private Integer publisherId; //发布人
    private Timestamp publishTime; //发布时间
    private int feedbackStatus; //状态 0-新发布未回复 1-已回复
    private String replyContent; //回复内容
    private Integer replyUserId; //回复人
    private Integer publisherStatus; //发布人状态

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackQuestion() {
        return feedbackQuestion;
    }

    public void setFeedbackQuestion(String feedbackQuestion) {
        this.feedbackQuestion = feedbackQuestion;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public int getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackStatus(int feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Integer getPublisherStatus() {
        return publisherStatus;
    }

    public void setPublisherStatus(Integer publisherStatus) {
        this.publisherStatus = publisherStatus;
    }
}
