package com.schoolCard.entity;

public class Classes {
    private Integer jzxId;

    private String jzxName;

    private Integer jzxMajorid;

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

    public Integer getJzxMajorid() {
        return jzxMajorid;
    }

    public void setJzxMajorid(Integer jzxMajorid) {
        this.jzxMajorid = jzxMajorid;
    }
}