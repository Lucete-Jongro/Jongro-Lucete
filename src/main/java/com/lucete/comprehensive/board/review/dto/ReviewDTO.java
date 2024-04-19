package com.lucete.comprehensive.board.review.dto;

import java.time.LocalDateTime;

public class ReviewDTO {
    private int revNo;
    private String revTitle;
    private String revContent;
    private LocalDateTime revDate;
    private char revReStatus;
    private String revCategory;
    private int memNo;
    private String memName;
    private LocalDateTime revUpdate;
    private char revDeleteStatus;
    private int prodSerial;
    private int revView;

    public ReviewDTO(){}

    public ReviewDTO(int revNo, String revTitle, String revContent, LocalDateTime revDate, char revReStatus, String revCategory, int memNo, String memName, LocalDateTime revUpdate, char revDeleteStatus, int prodSerial, int revView) {
        this.revNo = revNo;
        this.revTitle = revTitle;
        this.revContent = revContent;
        this.revDate = revDate;
        this.revReStatus = revReStatus;
        this.revCategory = revCategory;
        this.memNo = memNo;
        this.memName = memName;
        this.revUpdate = revUpdate;
        this.revDeleteStatus = revDeleteStatus;
        this.prodSerial = prodSerial;
        this.revView = revView;
    }

    public int getRevNo() {
        return revNo;
    }

    public void setRevNo(int revNo) {
        this.revNo = revNo;
    }

    public String getRevTitle() {
        return revTitle;
    }

    public void setRevTitle(String revTitle) {
        this.revTitle = revTitle;
    }

    public String getRevContent() {
        return revContent;
    }

    public void setRevContent(String revContent) {
        this.revContent = revContent;
    }

    public LocalDateTime getRevDate() {
        return revDate;
    }

    public void setRevDate(LocalDateTime revDate) {
        this.revDate = revDate;
    }

    public char getRevReStatus() {
        return revReStatus;
    }

    public void setRevReStatus(char revReStatus) {
        this.revReStatus = revReStatus;
    }

    public String getRevCategory() {
        return revCategory;
    }

    public void setRevCategory(String revCategory) {
        this.revCategory = revCategory;
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

    public LocalDateTime getRevUpdate() {
        return revUpdate;
    }

    public void setRevUpdate(LocalDateTime revUpdate) {
        this.revUpdate = revUpdate;
    }

    public char getRevDeleteStatus() {
        return revDeleteStatus;
    }

    public void setRevDeleteStatus(char revDeleteStatus) {
        this.revDeleteStatus = revDeleteStatus;
    }

    public int getProdSerial() {
        return prodSerial;
    }

    public void setProdSerial(int prodSerial) {
        this.prodSerial = prodSerial;
    }

    public int getRevView() {
        return revView;
    }

    public void setRevView(int revView) {
        this.revView = revView;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "revNo=" + revNo +
                ", revTitle='" + revTitle + '\'' +
                ", revContent='" + revContent + '\'' +
                ", revDate=" + revDate +
                ", revReStatus=" + revReStatus +
                ", revCategory='" + revCategory + '\'' +
                ", memNo=" + memNo +
                ", memName='" + memName + '\'' +
                ", revUpdate=" + revUpdate +
                ", revDeleteStatus=" + revDeleteStatus +
                ", prodSerial=" + prodSerial +
                ", revView=" + revView +
                '}';
    }
}
