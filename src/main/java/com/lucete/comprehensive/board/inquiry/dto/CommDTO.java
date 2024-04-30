package com.lucete.comprehensive.board.inquiry.dto;


import com.lucete.comprehensive.user.member.model.dto.MemberDTO;

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
    private MemberDTO memberDTO;
    private InquiryDTO inquiryDTO;

    public CommDTO(){}

    public CommDTO(int commKey, String reComment, LocalDateTime reDate, LocalDateTime commUpdate, char commDeleteStatus, int memNo, String memName, int inquiryNo, MemberDTO memberDTO, InquiryDTO inquiryDTO) {
        this.commKey = commKey;
        this.reComment = reComment;
        this.reDate = reDate;
        this.commUpdate = commUpdate;
        this.commDeleteStatus = commDeleteStatus;
        this.memNo = memNo;
        this.memName = memName;
        this.inquiryNo = inquiryNo;
        this.memberDTO = memberDTO;
        this.inquiryDTO = inquiryDTO;
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

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public InquiryDTO getInquiryDTO() {
        return inquiryDTO;
    }

    public void setInquiryDTO(InquiryDTO inquiryDTO) {
        this.inquiryDTO = inquiryDTO;
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
                ", memberDTO=" + memberDTO +
                ", inquiryDTO=" + inquiryDTO +
                '}';
    }
}
