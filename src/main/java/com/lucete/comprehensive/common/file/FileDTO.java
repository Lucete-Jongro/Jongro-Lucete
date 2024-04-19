package com.lucete.comprehensive.common.file;

import java.util.Date;

public class FileDTO {
    private int fileNo;         // 파일 번호(pk)
    private String fileName;    // 파일명
    private Date uploadDate;    // 업로드 일자
    private String filePass;    // 저장 경로 -> DB에 오타났습니다 Path인데 ㅠ
    private int fileSize;       // 용량
    private int prodSerial;     // 상품 일련번호 (fk)
    private int revNo;          // 리뷰 번호(fk)

    public FileDTO() {}

    public FileDTO(int fileNo, String fileName, Date uploadDate, String filePass, int fileSize, int prodSerial, int revNo) {
        this.fileNo = fileNo;
        this.fileName = fileName;
        this.uploadDate = uploadDate;
        this.filePass = filePass;
        this.fileSize = fileSize;
        this.prodSerial = prodSerial;
        this.revNo = revNo;
    }

    public int getFileNo() {
        return fileNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFilePass() {
        return filePass;
    }

    public void setFilePass(String filePass) {
        this.filePass = filePass;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getProdSerial() {
        return prodSerial;
    }

    public void setProdSerial(int prodSerial) {
        this.prodSerial = prodSerial;
    }

    public int getRevNo() {
        return revNo;
    }

    public void setRevNo(int revNo) {
        this.revNo = revNo;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "fileNo=" + fileNo +
                ", fileName='" + fileName + '\'' +
                ", uploadDate=" + uploadDate +
                ", filePass='" + filePass + '\'' +
                ", fileSize=" + fileSize +
                ", prodSerial=" + prodSerial +
                ", revNo=" + revNo +
                '}';
    }
}
