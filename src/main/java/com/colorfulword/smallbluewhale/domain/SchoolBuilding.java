package com.colorfulword.smallbluewhale.domain;

/**
 * 学校宿舍楼栋
 * Created by jone.sun on 2017/8/8.
 */
public class SchoolBuilding {
    private Integer schoolBuildingId;
    private String campus;
    private String area;
    private String building;

    public Integer getSchoolBuildingId() {
        return schoolBuildingId;
    }

    public void setSchoolBuildingId(Integer schoolBuildingId) {
        this.schoolBuildingId = schoolBuildingId;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}
