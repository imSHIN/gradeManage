package com.schoolCard.entity;

public class StudentAccount {
    private String jzxStudentid;

    private String jzxPassword;

    public String getJzxStudentid() {
        return jzxStudentid;
    }

    public void setJzxStudentid(String jzxStudentid) {
        this.jzxStudentid = jzxStudentid == null ? null : jzxStudentid.trim();
    }

    public String getJzxPassword() {
        return jzxPassword;
    }

    public void setJzxPassword(String jzxPassword) {
        this.jzxPassword = jzxPassword == null ? null : jzxPassword.trim();
    }
}