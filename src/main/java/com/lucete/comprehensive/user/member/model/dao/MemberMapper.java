package com.lucete.comprehensive.user.member.model.dao;

import com.lucete.comprehensive.product.model.dto.ProductDTO;
import com.lucete.comprehensive.user.member.model.dto.MemberDTO;
import com.lucete.comprehensive.user.member.model.dto.SignInDTO;
import com.lucete.comprehensive.user.member.model.dto.SignUpDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    void updateEmail(@Param("memName") String memId, @Param("email") String email);

    void changePassword(String memId, String password);

    List<MemberDTO> getAllMembers();

    String getPasswordByUserName(String memId);
    List<ProductDTO> orderList(int memNo);

    void changeAddress(@Param("memName") String memId, @Param("address") String address);
}
