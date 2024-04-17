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
        //암호화에서 비번 길이가 길어지기 때문에 password 최대길이 255로 변경
        int result = 0;


        try {
            result = memberMapper.regist(signupDTO);
            System.out.println("try 실행확인");
            System.out.println(signupDTO.getMemId()+signupDTO.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("캐치문 실행");
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

    public boolean selectMemberById(String memberId) {

        String result = memberMapper.selectMemberById(memberId);

        return result != null;
    }
}
