package com.lucete.comprehensive.board.inquiry.dto;

import com.lucete.comprehensive.user.member.MemberDTO;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class InquiryDTO {

    private int inquiryNo;
    private String inquiryTitle;
    private String inquiryContent;
    private LocalDateTime inquiryDate;
    private char inquiryReStatus;
    private String inquiryCategory;
    private int memNo;
    private String memName;
    private LocalDateTime inquiryUpdate;
    private char inquiryDeleteStatus;

    public InquiryDTO() {
    }

    public InquiryDTO(int inquiryNo, String inquiryTitle, String inquiryContent, LocalDateTime inquiryDate, char inquiryReStatus, String inquiryCategory, int memNo, String memName, LocalDateTime inquiryUpdate, char inquiryDeleteStatus) {
        this.inquiryNo = inquiryNo;
        this.inquiryTitle = inquiryTitle;
        this.inquiryContent = inquiryContent;
        this.inquiryDate = inquiryDate;
        this.inquiryReStatus = inquiryReStatus;
        this.inquiryCategory = inquiryCategory;
        this.memNo = memNo;
        this.memName = memName;
        this.inquiryUpdate = inquiryUpdate;
        this.inquiryDeleteStatus = inquiryDeleteStatus;
    }

    public int getInquiryNo() {
        return inquiryNo;
    }

    public void setInquiryNo(int inquiryNo) {
        this.inquiryNo = inquiryNo;
    }

    public String getInquiryTitle() {
        return inquiryTitle;
    }

    public void setInquiryTitle(String inquiryTitle) {
        this.inquiryTitle = inquiryTitle;
    }

    public String getInquiryContent() {
        return inquiryContent;
    }

    public void setInquiryContent(String inquiryContent) {
        this.inquiryContent = inquiryContent;
    }

    public LocalDateTime getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(LocalDateTime inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public char getInquiryReStatus() {
        return inquiryReStatus;
    }

    public void setInquiryReStatus(char inquiryReStatus) {
        this.inquiryReStatus = inquiryReStatus;
    }

    public String getInquiryCategory() {
        return inquiryCategory;
    }

    public void setInquiryCategory(String inquiryCategory) {
        this.inquiryCategory = inquiryCategory;
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

    public LocalDateTime getInquiryUpdate() {
        return inquiryUpdate;
    }

    public void setInquiryUpdate(LocalDateTime inquiryUpdate) {
        this.inquiryUpdate = inquiryUpdate;
    }

    public char getInquiryDeleteStatus() {
        return inquiryDeleteStatus;
    }

    public void setInquiryDeleteStatus(char inquiryDeleteStatus) {
        this.inquiryDeleteStatus = inquiryDeleteStatus;
    }

    @Override
    public String toString() {
        return "InquiryDTO{" +
                "inquiryNo=" + inquiryNo +
                ", inquiryTitle='" + inquiryTitle + '\'' +
                ", inquiryContent='" + inquiryContent + '\'' +
                ", inquiryDate=" + inquiryDate +
                ", inquiryReStatus=" + inquiryReStatus +
                ", inquiryCategory='" + inquiryCategory + '\'' +
                ", memNo=" + memNo +
                ", memName='" + memName + '\'' +
                ", inquiryUpdate=" + inquiryUpdate +
                ", inquiryDeleteStatus=" + inquiryDeleteStatus +
                '}';
    }
}