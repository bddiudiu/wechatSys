package com.alaso.wechat.server.entity;

/**
 * 部门实体类
 * Created by adam on 11/12/15.
 */
public class Dept extends BaseEntity {

    private Integer id;
    private String deptName;
    private String deptDesc;
    private String deptAlias;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

    public String getDeptAlias() {
        return deptAlias;
    }

    public void setDeptAlias(String deptAlias) {
        this.deptAlias = deptAlias;
    }
}
