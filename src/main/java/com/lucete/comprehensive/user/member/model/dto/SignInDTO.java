package com.lucete.comprehensive.user.member.model.dto;

import com.lucete.comprehensive.user.userRole.UserRole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.lucete.comprehensive.user.userRole.UserRole.ADMIN;
import static com.lucete.comprehensive.user.userRole.UserRole.USER;

public class SignInDTO extends MemberDTO implements Serializable {
    private int memNo;
    private String memId;
    private String memName;
    private String password;
    private String email;
    private char adminAuthority;
    private UserRole userRole=ADMIN;
    private String phone;

    public SignInDTO(int memNo, String memId, String memName, String password, String email, char adminAuthority, String phone) {
        this.memNo = memNo;
        this.memId = memId;
        this.memName = memName;
        this.password = password;
        this.email = email;
        this.adminAuthority = adminAuthority;
        this.phone = phone;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }



    public SignInDTO(int memNo, String memId, String memName, String password, char adminAuthority, UserRole userRole) {
        this.memNo = memNo;
        this.memId = memId;
        this.memName = memName;
        this.password = password;
        this.adminAuthority = adminAuthority;
        this.userRole = userRole;
    }
    public SignInDTO(int memNo, String memId, String memName, String password, char adminAuthority) {
        this.memNo = memNo;
        this.memId = memId;
        this.memName = memName;
        this.password = password;
        this.adminAuthority = adminAuthority;

        // 관리자 권한이 'Y'인 경우 ADMIN 역할을 할당
        if (adminAuthority == 'Y') {
            this.userRole = UserRole.ADMIN;
        } else {
            this.userRole = USER;
        }
    }

    public char getAdminAuthority() {
        return adminAuthority;
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





    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setAdminAuthority(char adminAuthority) {
        this.adminAuthority = adminAuthority;
        // 관리자 권한이 'Y'인 경우 ADMIN 역할을 할당
        if (adminAuthority == 'Y') {
            this.userRole = UserRole.ADMIN;
        } else {
            this.userRole = USER;
        }
    }

    // 사용자의 권한을 반환하는 메서드
    public UserRole getRole() {
        return userRole;
    }

}
