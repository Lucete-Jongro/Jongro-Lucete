package com.lucete.comprehensive.user.blacklist.model.dto;

import java.io.Serializable;
import java.util.Date;

public class BlacklistDTO implements Serializable {
    private int blacklistNo;
    private char blacklistStatus;
    private String blacklistReason;
    private Date blacklistStartDate;
    private int memNo;
    private String email;

    private Date blacklistEndDate;

    public BlacklistDTO(int memNo, String email, String blacklistReason, Date blacklistStartDate,   Date blacklistEndDate) {

        this.blacklistReason = blacklistReason;
        this.blacklistStartDate = blacklistStartDate;
        this.memNo = memNo;
        this.blacklistEndDate = blacklistEndDate;
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBlacklistNo() {
        return blacklistNo;
    }

    public void setBlacklistNo(int blacklistNo) {
        this.blacklistNo = blacklistNo;
    }

    public char getBlacklistStatus() {
        return blacklistStatus;
    }

    public void setBlacklistStatus(char blacklistStatus) {
        this.blacklistStatus = blacklistStatus;
    }

    public String getBlacklistReason() {
        return blacklistReason;
    }

    public void setBlacklistReason(String blacklistReason) {
        this.blacklistReason = blacklistReason;
    }

    public Date getBlacklistStartDate() {
        return blacklistStartDate;
    }

    public void setBlacklistStartDate(Date blacklistStartDate) {
        this.blacklistStartDate = blacklistStartDate;
    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public Date getBlacklistEndDate() {
        return blacklistEndDate;
    }

    public void setBlacklistEndDate(Date blacklistEndDate) {
        this.blacklistEndDate = blacklistEndDate;
    }

    @Override
    public String toString() {
        return "BlacklistDTO{" +
                "blacklistNo=" + blacklistNo +
                ", blacklistStatus=" + blacklistStatus +
                ", blacklistReason='" + blacklistReason + '\'' +
                ", blacklistStartDate=" + blacklistStartDate +
                ", memNo=" + memNo +
                ", blacklistEndDate=" + blacklistEndDate +
                '}';
    }
}
