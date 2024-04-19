package com.lucete.comprehensive.auth.model;

import com.lucete.comprehensive.user.member.model.dto.SignInDTO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AuthDetails implements UserDetails {

    private SignInDTO loginUserDTO;

    public AuthDetails(){}

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
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        loginUserDTO.getRole().forEach(role -> authorities.add(() -> role));

        return authorities;
    }

    @Override
    public String getPassword() {
        return loginUserDTO.getPassword();
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
