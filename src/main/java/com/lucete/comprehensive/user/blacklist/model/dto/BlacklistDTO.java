package com.lucete.comprehensive.user.blacklist.model.dto;

import java.io.Serializable;
import java.util.Date;

public class BlacklistDTO implements Serializable {
    private int blacklistNo;
    private char blacklistStatus;
    private String blacklistReason;
    private Date blacklistStartDate;
    private int memNo;
    private Date blacklistEndDate;

    public BlacklistDTO(int blacklistNo, char blacklistStatus, String blacklistReason, Date blacklistStartDate, int memNo, Date blacklistEndDate) {
        this.blacklistNo = blacklistNo;
        this.blacklistStatus = blacklistStatus;
        this.blacklistReason = blacklistReason;
        this.blacklistStartDate = blacklistStartDate;
        this.memNo = memNo;
        this.blacklistEndDate = blacklistEndDate;
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
