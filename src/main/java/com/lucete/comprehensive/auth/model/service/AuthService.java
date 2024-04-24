package com.lucete.comprehensive.auth.model.service;



import com.lucete.comprehensive.auth.model.AuthDetails;
import com.lucete.comprehensive.user.member.model.dto.SignInDTO;
import com.lucete.comprehensive.user.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private MemberService userService;

    @Override
    public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {

        SignInDTO login = userService.findByMemberId(memId);
        //System.out.println(login.getMemName()+login.getMemId());
        //여기까진 괜찮은데....

        if(Objects.isNull(login)) {
            System.out.println("오류");
            throw new UsernameNotFoundException("해당하는 회원 정보가 존재하지 않습니다.");

        }

        return new AuthDetails(login);
    }
}
