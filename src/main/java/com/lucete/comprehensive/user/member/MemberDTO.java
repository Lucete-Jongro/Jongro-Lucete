package com.lucete.comprehensive.user.member;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

public class MemberDTO {

    private int memNo;
    private String memName;

    public MemberDTO(){}

    public MemberDTO(int memNo, String memName) {
        this.memNo = memNo;
        this.memName = memName;
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

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memNo=" + memNo +
                ", memName='" + memName + '\'' +
                '}';
    }
}
