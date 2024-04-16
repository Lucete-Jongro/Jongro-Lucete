package com.lucete.comprehensive.user.member.model.service;

import com.lucete.comprehensive.user.member.model.dao.MemberMapper;
import com.lucete.comprehensive.user.member.model.dto.SignInDTO;
import com.lucete.comprehensive.user.member.model.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public int regist(@RequestBody SignUpDTO signupDTO) {
        System.out.println(signupDTO.getMemId()+signupDTO.getPassword());
        signupDTO.setPassword(passwordEncoder.encode(signupDTO.getPassword()));

        int result = 0;


        try {
            result = memberMapper.regist(signupDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public SignInDTO findMem(String MemId) {

        SignInDTO login = memberMapper.findMem(MemId);

        if(!Objects.isNull(login)) {
            return login;
        } else {
            return null;
        }

    }
}
