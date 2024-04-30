package com.lucete.comprehensive.user.member.model.dto;

import com.lucete.comprehensive.user.userRole.UserRole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignInDTO extends MemberDTO implements Serializable {
    private int memNo;
    private String memId;
    private String memName;
    private String password;
    private char adminAuthority;
    private UserRole userRole;



    public SignInDTO(int memNo, String memId, String memName, String password, char adminAuthority) {
        this.memNo = memNo;
        this.memId = memId;
        this.memName = memName;
        this.password = password;
        this.adminAuthority = adminAuthority;
    }

    public SignInDTO(int memNo, String memId, String memName, String password, char adminAuthority, UserRole userRole) {
        this.memNo = memNo;
        this.memId = memId;
        this.memName = memName;
        this.password = password;
        this.adminAuthority = adminAuthority;
        this.userRole = userRole;
    }

    public char getAdminAuthority() {
        return adminAuthority;
    }

    public void setAdminAuthority(char adminAuthority) {
        this.adminAuthority = adminAuthority;
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

    public List<String> getRole() {
        if(this.userRole.getRole().length() > 0) {
            return Arrays.asList(this.userRole.getRole().split(","));
        }

        return new ArrayList<>();
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
