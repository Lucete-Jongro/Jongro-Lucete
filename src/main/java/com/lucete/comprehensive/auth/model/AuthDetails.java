package com.lucete.comprehensive.auth.model;

import com.lucete.comprehensive.user.member.model.dto.SignInDTO;

import com.lucete.comprehensive.user.member.model.dto.SignUpDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

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

        return Collections.singleton(new SimpleGrantedAuthority("USER"));
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
