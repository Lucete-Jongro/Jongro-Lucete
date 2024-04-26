package com.lucete.comprehensive.board.notice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NoticeDTO {
    private int noticeNo;
    private String noticeTitle;
    private String noticeContent;
    private LocalDate noticeDate;
    private char noticeStatus;
    private String noticeCategory;
    private LocalDateTime noticeUpdate;
    private char noticeDeleteStatus;
    private int memNo;

    public NoticeDTO() {
    }

    public NoticeDTO(int noticeNo, String noticeTitle, String noticeContent,
                     LocalDate noticeDate, char noticeStatus, String noticeCategory,
                     LocalDateTime noticeUpdate, char noticeDeleteStatus, int memNo) {
        this.noticeNo = noticeNo;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeDate = noticeDate;
        this.noticeStatus = noticeStatus;
        this.noticeCategory = noticeCategory;
        this.noticeUpdate = noticeUpdate;
        this.noticeDeleteStatus = noticeDeleteStatus;
        this.memNo = memNo;
    }

    public int getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public LocalDate getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(LocalDate noticeDate) {
        this.noticeDate = noticeDate;
    }

    public char getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(char noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public String getNoticeCategory() {
        return noticeCategory;
    }

    public void setNoticeCategory(String noticeCategory) {
        this.noticeCategory = noticeCategory;
    }

    public LocalDateTime getNoticeUpdate() {
        return noticeUpdate;
    }

    public void setNoticeUpdate(LocalDateTime noticeUpdate) {
        this.noticeUpdate = noticeUpdate;
    }

    public char getNoticeDeleteStatus() {
        return noticeDeleteStatus;
    }

    public void setNoticeDeleteStatus(char noticeDeleteStatus) {
        this.noticeDeleteStatus = noticeDeleteStatus;
    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "noticeNo=" + noticeNo +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeDate=" + noticeDate +
                ", noticeStatus=" + noticeStatus +
                ", noticeCategory='" + noticeCategory + '\'' +
                ", noticeUpdate=" + noticeUpdate +
                ", noticeDeleteStatus=" + noticeDeleteStatus +
                ", memNo=" + memNo +
                '}';
    }
}
