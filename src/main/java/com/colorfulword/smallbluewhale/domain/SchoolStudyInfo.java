package com.colorfulword.smallbluewhale.domain;

/**
 * 学校院系
 * Created by jone.sun on 2017/8/8.
 */
public class SchoolStudyInfo {

    private Integer studyInfoId;
    private String campus; //所属校区
    private String department; //院系

    public Integer getStudyInfoId() {
        return studyInfoId;
    }

    public void setStudyInfoId(Integer studyInfoId) {
        this.studyInfoId = studyInfoId;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
