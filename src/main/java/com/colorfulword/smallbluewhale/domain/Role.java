package com.colorfulword.smallbluewhale.domain;

/**
 * Created by yangyibo on 17/1/17.
 */

public class Role {

    private Integer roleId;
    private String roleName;
    private String roleType;

    public Role(){}

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
