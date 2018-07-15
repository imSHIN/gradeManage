package com.schoolCard.entity;

public class TeacherAccount {
    private Integer jzxTeacherid;

    private String jzxPassword;

    public Integer getJzxTeacherid() {
        return jzxTeacherid;
    }

    public void setJzxTeacherid(Integer jzxTeacherid) {
        this.jzxTeacherid = jzxTeacherid;
    }

    public String getJzxPassword() {
        return jzxPassword;
    }

    public void setJzxPassword(String jzxPassword) {
        this.jzxPassword = jzxPassword == null ? null : jzxPassword.trim();
    }
}