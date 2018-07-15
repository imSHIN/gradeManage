package com.schoolCard.entity;

public class Score {
    private String jzxStudentid;

    private Integer jzxCourseid;

    private Integer jzxScore;

    public String getJzxStudentid() {
        return jzxStudentid;
    }

    public void setJzxStudentid(String jzxStudentid) {
        this.jzxStudentid = jzxStudentid == null ? null : jzxStudentid.trim();
    }

    public Integer getJzxCourseid() {
        return jzxCourseid;
    }

    public void setJzxCourseid(Integer jzxCourseid) {
        this.jzxCourseid = jzxCourseid;
    }

    public Integer getJzxScore() {
        return jzxScore;
    }

    public void setJzxScore(Integer jzxScore) {
        this.jzxScore = jzxScore;
    }
}