package com.lucete.comprehensive.user.member.model.dto;

import java.io.Serializable;

public class SignInDTO implements Serializable {
    private int memNo;
    private String memId;
    private String memName;
    private String password;


    public SignInDTO(int memNo, String memId, String memName, String password) {
        this.memNo = memNo;
        this.memId = memId;
        this.memName = memName;
        this.password = password;

    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
