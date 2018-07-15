package com.schoolCard.entity;

public class Card {
    private String id;

    private String studentid;

    private Integer overage;

    private Byte cardstatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public Integer getOverage() {
        return overage;
    }

    public void setOverage(Integer overage) {
        this.overage = overage;
    }

    public Byte getCardstatus() {
        return cardstatus;
    }

    public void setCardstatus(Byte cardstatus) {
        this.cardstatus = cardstatus;
    }
}