package com.lucete.comprehensive.user.member.model.dto;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

import java.util.Date;

public class MemberDTO {


    private int memNo;
    private String memName;
    private String memId;

    private String password;
    private String email;
    private String phone;
    private String address;
    private Date memDate;
    public MemberDTO(){}
    public MemberDTO(int memNo, String memName, String memId, String password, String email, String phone, String address, Date memDate) {
        this.memNo = memNo;
        this.memName = memName;
        this.memId = memId;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.memDate = memDate;
    }

    public MemberDTO(int memNo, String memName, String memId, String phone, String address) {
        this.memNo = memNo;
        this.memName = memName;
        this.memId = memId;
        this.phone = phone;
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getMemDate() {
        return memDate;
    }

    public void setMemDate(Date memDate) {
        this.memDate = memDate;
    }
}
