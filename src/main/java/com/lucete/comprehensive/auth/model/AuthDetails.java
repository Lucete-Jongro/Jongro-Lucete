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

    public String getMemberId() {
        System.out.println(loginUserDTO);
        return loginUserDTO.getMemId();
    }
    public AuthDetails(SignInDTO loginUserDTO) {
        this.loginUserDTO = loginUserDTO;
    }

    public SignInDTO getLoginUserDTO() {
        return loginUserDTO;
    }

    public void setLoginUserDTO(SignInDTO loginUserDTO) {
        this.loginUserDTO = loginUserDTO;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 사용자의 실제 권한 정보를 반환해야 합니다.
        // 예를 들어, SignInDTO에서 가져온 UserRole을 기반으로 권한을 설정할 수 있습니다.
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (loginUserDTO != null && loginUserDTO.getRole() != null) {
            authorities.add(new SimpleGrantedAuthority(loginUserDTO.getRole().getRole()));
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
