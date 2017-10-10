package com.colorfulword.smallbluewhale.domain;

import java.sql.Timestamp;

/**
 * 失物
 * Created by jone.sun on 2017/8/10.
 */
public class LostArticle {
    private Integer lostArticleId;
    private Integer publisherId; //发布人
    private Timestamp publishTime; //发布时间
    private String lostUser; //失主
    private String lostUserMobile; //失主联系电话
    private String lostArticleName; //物品
    private String campus; //所属校区 仙林|鼓楼
    private String position; //位置
    private String lostArticleType; //失物类型 卡证；书籍；衣包；其他
    private Integer lostArticleStatus; // 状态 0 新增 -1已下线
    private String lostArticlePic; //图片

    public Integer getLostArticleId() {
        return lostArticleId;
    }

    public void setLostArticleId(Integer lostArticleId) {
        this.lostArticleId = lostArticleId;
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

    public String getLostUser() {
        return lostUser;
    }

    public void setLostUser(String lostUser) {
        this.lostUser = lostUser;
    }

    public String getLostUserMobile() {
        return lostUserMobile;
    }

    public void setLostUserMobile(String lostUserMobile) {
        this.lostUserMobile = lostUserMobile;
    }

    public String getLostArticleName() {
        return lostArticleName;
    }

    public void setLostArticleName(String lostArticleName) {
        this.lostArticleName = lostArticleName;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLostArticleType() {
        return lostArticleType;
    }

    public void setLostArticleType(String lostArticleType) {
        this.lostArticleType = lostArticleType;
    }

    public Integer getLostArticleStatus() {
        return lostArticleStatus;
    }

    public void setLostArticleStatus(Integer lostArticleStatus) {
        this.lostArticleStatus = lostArticleStatus;
    }

    public String getLostArticlePic() {
        return lostArticlePic;
    }

    public void setLostArticlePic(String lostArticlePic) {
        this.lostArticlePic = lostArticlePic;
    }
}
