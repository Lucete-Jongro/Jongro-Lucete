package com.lucete.comprehensive.board.inquiry.dto;

import java.time.LocalDateTime;

public class CommDTO {

    private int commKey;
    private String reComment;
    private LocalDateTime reDate;
    private LocalDateTime commUpdate;
    private char commDeleteStatus;
    private  int memNo;
    private String memName;
    private int inquiryNo;

    public CommDTO(){}

    public CommDTO(int commKey, String reComment, LocalDateTime reDate, LocalDateTime commUpdate, char commDeleteStatus, int memNo, String memName, int inquiryNo) {
        this.commKey = commKey;
        this.reComment = reComment;
        this.reDate = reDate;
        this.commUpdate = commUpdate;
        this.commDeleteStatus = commDeleteStatus;
        this.memNo = memNo;
        this.memName = memName;
        this.inquiryNo = inquiryNo;
    }

    public int getCommKey() {
        return commKey;
    }

    public void setCommKey(int commKey) {
        this.commKey = commKey;
    }

    public String getReComment() {
        return reComment;
    }

    public void setReComment(String reComment) {
        this.reComment = reComment;
    }

    public LocalDateTime getReDate() {
        return reDate;
    }

    public void setReDate(LocalDateTime reDate) {
        this.reDate = reDate;
    }

    public LocalDateTime getCommUpdate() {
        return commUpdate;
    }

    public void setCommUpdate(LocalDateTime commUpdate) {
        this.commUpdate = commUpdate;
    }

    public char getCommDeleteStatus() {
        return commDeleteStatus;
    }

    public void setCommDeleteStatus(char commDeleteStatus) {
        this.commDeleteStatus = commDeleteStatus;
    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public int getInquiryNo() {
        return inquiryNo;
    }

    public void setInquiryNo(int inquiryNo) {
        this.inquiryNo = inquiryNo;
    }

    @Override
    public String toString() {
        return "CommDTO{" +
                "commKey=" + commKey +
                ", reComment='" + reComment + '\'' +
                ", reDate=" + reDate +
                ", commUpdate=" + commUpdate +
                ", commDeleteStatus=" + commDeleteStatus +
                ", memNo=" + memNo +
                ", memName='" + memName + '\'' +
                ", inquiryNo=" + inquiryNo +
                '}';
    }
}
