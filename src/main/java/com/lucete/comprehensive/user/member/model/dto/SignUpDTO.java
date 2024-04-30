package com.lucete.comprehensive.user.member.model.dto;

import java.io.Serializable;
import java.util.Date;

public class SignUpDTO extends MemberDTO implements Serializable{
    private String memId;
    private String memName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String role;



    public SignUpDTO(String memId, String memName, String password, String email, String phone, String address) {
        this.memId = memId;
        this.memName = memName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}