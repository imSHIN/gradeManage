package com.schoolCard.entity;

public class Course {
    private Integer jzxId;

    private String jzxName;

    private String jzxTeachername;

    private String jzxSchoolitem;

    private Integer jzxHour;

    private String jzxExam;

    private Integer jzxScore;

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

    public String getJzxTeachername() {
        return jzxTeachername;
    }

    public void setJzxTeachername(String jzxTeachername) {
        this.jzxTeachername = jzxTeachername == null ? null : jzxTeachername.trim();
    }

    public String getJzxSchoolitem() {
        return jzxSchoolitem;
    }

    public void setJzxSchoolitem(String jzxSchoolitem) {
        this.jzxSchoolitem = jzxSchoolitem == null ? null : jzxSchoolitem.trim();
    }

    public Integer getJzxHour() {
        return jzxHour;
    }

    public void setJzxHour(Integer jzxHour) {
        this.jzxHour = jzxHour;
    }

    public String getJzxExam() {
        return jzxExam;
    }

    public void setJzxExam(String jzxExam) {
        this.jzxExam = jzxExam == null ? null : jzxExam.trim();
    }

    public Integer getJzxScore() {
        return jzxScore;
    }

    public void setJzxScore(Integer jzxScore) {
        this.jzxScore = jzxScore;
    }
}