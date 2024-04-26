package com.lucete.comprehensive.user.member;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

public class MemberDTO {

    private int memNo;
    private String memName;
    private String memId;

    public MemberDTO() {

    }

    public MemberDTO(int memNo, String memName, String memId) {
        this.memNo = memNo;
        this.memName = memName;
        this.memId = memId;
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

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memNo=" + memNo +
                ", memName='" + memName + '\'' +
                ", memId='" + memId + '\'' +
                '}';
    }
}
