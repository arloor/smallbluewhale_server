package com.colorfulword.smallbluewhale.domain;

/**
 *  个人风采/员工风采
 * Created by jone.sun on 2017/8/8.
 */
public class PersonalStyle {

    private Integer personalStyleId;
    private String userNumber; //工号
    private String userName; //姓名
    private String mobile; //手机号
    private String content; //事迹
    private String campus;//所属院系
    private String type; //员工类型
    private Integer buildingId; //所在楼栋
    private String pics; //图册


    public Integer getPersonalStyleId() {
        return personalStyleId;
    }

    public void setPersonalStyleId(Integer personalStyleId) {
        this.personalStyleId = personalStyleId;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }
}
