package com.schoolCard.entity;

public class Student {
    private String jzxId;

    private String jzxName;

    private String jzxSex;

    private Integer jzxAge;

    private String jzxAdress;

    private Integer jzxAllscore;

    private String jzxTeachername;

    private Integer jzxClassid;

    public String getJzxId() {
        return jzxId;
    }

    public void setJzxId(String jzxId) {
        this.jzxId = jzxId == null ? null : jzxId.trim();
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

    public String getJzxAdress() {
        return jzxAdress;
    }

    public void setJzxAdress(String jzxAdress) {
        this.jzxAdress = jzxAdress == null ? null : jzxAdress.trim();
    }

    public Integer getJzxAllscore() {
        return jzxAllscore;
    }

    public void setJzxAllscore(Integer jzxAllscore) {
        this.jzxAllscore = jzxAllscore;
    }

    public String getJzxTeachername() {
        return jzxTeachername;
    }

    public void setJzxTeachername(String jzxTeachername) {
        this.jzxTeachername = jzxTeachername == null ? null : jzxTeachername.trim();
    }

    public Integer getJzxClassid() {
        return jzxClassid;
    }

    public void setJzxClassid(Integer jzxClassid) {
        this.jzxClassid = jzxClassid;
    }
}