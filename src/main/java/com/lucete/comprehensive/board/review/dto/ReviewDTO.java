package com.lucete.comprehensive.board.review.dto;

import com.lucete.comprehensive.common.file.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Date;

public class ReviewDTO {
    private int revNo;
    private String revTitle;
    private String revContent;
    private Date revDate;
    private char revReStatus;
    private String revCategory;
    private int memNo;
    private String memName;
    private Date revUpdate;
    private char revDeleteStatus;
    private int prodSerial;
    private int revView;
    private FileDTO file;



    public ReviewDTO(){}

    public ReviewDTO(int revNo, String revTitle, String revContent, Date revDate, char revReStatus, String revCategory, int memNo, String memName, Date revUpdate, char revDeleteStatus, int prodSerial, int revView, FileDTO file) {
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
        this.file = file;
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

    public Date getRevDate() {
        return revDate;
    }

    public void setRevDate(Date revDate) {
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

    public Date getRevUpdate() {
        return revUpdate;
    }

    public void setRevUpdate(Date revUpdate) {
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

    public FileDTO getFile() {
        return file;
    }

    public void setFile(FileDTO file) {
        this.file = file;
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
                ", file=" + file +
                '}';
    }
}
