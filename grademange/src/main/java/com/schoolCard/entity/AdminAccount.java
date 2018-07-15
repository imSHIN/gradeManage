package com.schoolCard.entity;

public class AdminAccount {
    private Integer jzxId;

    private String jzxPassword;

    public Integer getJzxId() {
        return jzxId;
    }

    public void setJzxId(Integer jzxId) {
        this.jzxId = jzxId;
    }

    public String getJzxPassword() {
        return jzxPassword;
    }

    public void setJzxPassword(String jzxPassword) {
        this.jzxPassword = jzxPassword == null ? null : jzxPassword.trim();
    }
}