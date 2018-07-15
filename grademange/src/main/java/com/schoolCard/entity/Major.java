package com.schoolCard.entity;

public class Major {
    private Integer jzxId;

    private String jzxName;

    private Integer jzxYears;

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

    public Integer getJzxYears() {
        return jzxYears;
    }

    public void setJzxYears(Integer jzxYears) {
        this.jzxYears = jzxYears;
    }
}