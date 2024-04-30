package com.lucete.comprehensive.auth.model;

import com.lucete.comprehensive.user.member.model.dto.SignInDTO;

import com.lucete.comprehensive.user.member.model.dto.SignUpDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AuthDetails implements UserDetails {

    private SignInDTO loginUserDTO;


    public AuthDetails(SignUpDTO signupDTO){}

    public AuthDetails() {

    }

    public String getMemberId() {
        System.out.println(loginUserDTO);
        return loginUserDTO.getMemId();
    }
    public AuthDetails(SignInDTO loginUserDTO) {
        this.loginUserDTO = loginUserDTO;
    }

    public String getAddress(){
        return loginUserDTO.getAddress();
    }
    public SignInDTO getLoginUserDTO() {
        return loginUserDTO;
    }

    public void setLoginUserDTO(SignInDTO loginUserDTO) {
        this.loginUserDTO = loginUserDTO;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // 사용자의 역할에 따라 권한을 설정합니다.
        if (loginUserDTO != null) {
            // 사용자의 역할에 따라 권한을 추가합니다.
            if (loginUserDTO.getRole() != null) {
                authorities.add(new SimpleGrantedAuthority(loginUserDTO.getRole().getRole()));
            }

            // 사용자의 관리자 권한에 따라 ADMIN 권한을 추가합니다.
            if (loginUserDTO.getAdminAuthority() == 'Y') {
                authorities.add(new SimpleGrantedAuthority("ADMIN"));
            }
        }

        return authorities;
    }




    @Override
    public String getPassword() {
        return loginUserDTO.getPassword();
    }

    public String getEmail() {
        return loginUserDTO.getEmail();
    }
    public String getPhone() {
        return loginUserDTO.getPhone();
    }

    public int getmemNo(){
        return loginUserDTO.getMemNo();
    }

    @Override
    public String getUsername() {
        return loginUserDTO.getMemName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
