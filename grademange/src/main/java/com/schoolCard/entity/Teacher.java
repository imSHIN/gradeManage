package com.schoolCard.entity;

public class Teacher {
    private Integer jzxId;

    private String jzxName;

    private String jzxSex;

    private Integer jzxAge;

    private String jzxPosition;

    private String jzxTel;

    public Integer getJzxId() {
        return jzxId;
    }

    public void setJzxId(Integer jzxId) {
        this.jzxId = jzxId;
    }

    public String getJzxName() {
        return jzxName;
    }

    public void setJzxName(String jzxName) {
        this.jzxName = jzxName == null ? null : jzxName.trim();
    }

    public String getJzxSex() {
        return jzxSex;
    }

    public void setJzxSex(String jzxSex) {
        this.jzxSex = jzxSex == null ? null : jzxSex.trim();
    }

    public Integer getJzxAge() {
        return jzxAge;
    }

    public void setJzxAge(Integer jzxAge) {
        this.jzxAge = jzxAge;
    }

    public String getJzxPosition() {
        return jzxPosition;
    }

    public void setJzxPosition(String jzxPosition) {
        this.jzxPosition = jzxPosition == null ? null : jzxPosition.trim();
    }

    public String getJzxTel() {
        return jzxTel;
    }

    public void setJzxTel(String jzxTel) {
        this.jzxTel = jzxTel == null ? null : jzxTel.trim();
    }
}