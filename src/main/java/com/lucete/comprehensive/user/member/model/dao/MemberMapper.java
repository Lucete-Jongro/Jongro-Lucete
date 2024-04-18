package com.lucete.comprehensive.user.member.model.dao;

import com.lucete.comprehensive.user.member.model.dto.SignInDTO;
import com.lucete.comprehensive.user.member.model.dto.SignUpDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int regist(SignUpDTO signupDTO);

    SignInDTO findByUsername(String username);
    String selectMemberById(String memberId);

}
