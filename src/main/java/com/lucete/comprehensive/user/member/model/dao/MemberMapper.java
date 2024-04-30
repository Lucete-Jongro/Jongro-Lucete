package com.lucete.comprehensive.user.member.model.dao;

import com.lucete.comprehensive.user.member.model.dto.MemberDTO;
import com.lucete.comprehensive.user.member.model.dto.SignInDTO;
import com.lucete.comprehensive.user.member.model.dto.SignUpDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface MemberMapper {
    int regist(SignUpDTO signupDTO);

    SignInDTO findByMemberId(String memId);
    String selectMemberById(String memId);

    String findId(String memName, String phone );

    List<MemberDTO> selectMembers( String memName,
                                   String address,
                                   Date startDate,
                                   Date endDate);


}
