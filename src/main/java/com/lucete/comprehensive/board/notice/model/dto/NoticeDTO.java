package com.lucete.comprehensive.board.notice.model.dto;

import java.time.LocalDateTime;

public class NoticeDTO {
    private int noitceNo;
    private String noticeTitle;
    private String noticeContent;
    private LocalDateTime noticeDate;
    private char noticeStatus;
    private String noticeCategory;
    private LocalDateTime noticeUpdate;
    private char noticeDeleteStatus;

    public NoticeDTO() {
    }

    public NoticeDTO(int noitceNo, String noticeTitle, String noticeContent,
                     LocalDateTime noticeDate, char noticeStatus, String noticeCategory,
                     LocalDateTime noticeUpdate, char noticeDeleteStatus) {
        this.noitceNo = noitceNo;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeDate = noticeDate;
        this.noticeStatus = noticeStatus;
        this.noticeCategory = noticeCategory;
        this.noticeUpdate = noticeUpdate;
        this.noticeDeleteStatus = noticeDeleteStatus;
    }

    public int getNoitceNo() {
        return noitceNo;
    }

    public void setNoitceNo(int noitceNo) {
        this.noitceNo = noitceNo;
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

    public LocalDateTime getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(LocalDateTime noticeDate) {
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

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "noitceNo=" + noitceNo +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeDate=" + noticeDate +
                ", noticeStatus=" + noticeStatus +
                ", noticeCategory='" + noticeCategory + '\'' +
                ", noticeUpdate=" + noticeUpdate +
                ", noticeDeleteStatus=" + noticeDeleteStatus +
                '}';
    }
}
