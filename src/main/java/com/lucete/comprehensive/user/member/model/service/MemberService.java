package com.lucete.comprehensive.user.member.model.service;

import com.lucete.comprehensive.user.member.model.dao.MemberMapper;
import com.lucete.comprehensive.user.member.model.dto.MemberDTO;
import com.lucete.comprehensive.user.member.model.dto.SignInDTO;
import com.lucete.comprehensive.user.member.model.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
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

    public SignInDTO findByMemberId(String memId) {

        SignInDTO login = memberMapper.findByMemberId(memId);


        if(!Objects.isNull(login)) {
            System.out.println("록긩ㄴ 리턴함");
            return login;
            
        } else {
            return null;
        }

    }

    public boolean selectMemberById(String memId) { //아아이디 중ㅂ복 찾을때

        String result = memberMapper.selectMemberById(memId);
        System.out.println(result);

        return result != null;
    }

    public String findId(String memName, String phone){
        String result = memberMapper.findId(memName,phone);
        if(result == null){
            result="해당하는 아이디가 없습니다.";

        }else {
            result = "고객님의 아이디는 "+result+" 입니다.";
        }
        return result;
    }
    public List<MemberDTO> selectMembers(String memName, String address, Date startDate, Date endDate){
        List<MemberDTO> result = memberMapper.selectMembers(memName,address,startDate,endDate);
        return result;
    }
    public void updateEmail(int memNo,String email){
        memberMapper.updateEmail(memNo, email);

    }


}
