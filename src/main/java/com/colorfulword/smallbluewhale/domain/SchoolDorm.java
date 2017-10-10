package com.colorfulword.smallbluewhale.domain;

/**
 * 学校宿舍
 * Created by jone.sun on 2017/8/8.
 */
public class SchoolDorm {

    private Integer schoolDormId;
    private String schoolDormName;
    private Integer schoolBuildingId; //所属楼栋

    public Integer getSchoolDormId() {
        return schoolDormId;
    }

    public void setSchoolDormId(Integer schoolDormId) {
        this.schoolDormId = schoolDormId;
    }

    public String getSchoolDormName() {
        return schoolDormName;
    }

    public void setSchoolDormName(String schoolDormName) {
        this.schoolDormName = schoolDormName;
    }


    public Integer getSchoolBuildingId() {
        return schoolBuildingId;
    }

    public void setSchoolBuildingId(Integer schoolBuildingId) {
        this.schoolBuildingId = schoolBuildingId;
    }
}
