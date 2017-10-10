package com.colorfulword.smallbluewhale.domain;

public class User {
    private Integer userId;
    private String userNumber; //工号/学号/管理员用户名
    private String weChat; //微信号
    private String code; //授权码/密码
    private Integer status;
    private Integer userSchoolBuildingId; //所属楼栋
    private Role role;
    private SchoolBuilding schoolBuilding;

    private Integer roleId; //提交用

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserSchoolBuildingId() {
        return userSchoolBuildingId;
    }

    public void setUserSchoolBuildingId(Integer userSchoolBuildingId) {
        this.userSchoolBuildingId = userSchoolBuildingId;
    }

    public SchoolBuilding getSchoolBuilding() {
        return schoolBuilding;
    }

    public void setSchoolBuilding(SchoolBuilding schoolBuilding) {
        this.schoolBuilding = schoolBuilding;
    }
}
