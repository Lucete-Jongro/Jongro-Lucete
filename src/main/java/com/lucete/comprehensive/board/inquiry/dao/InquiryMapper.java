package com.lucete.comprehensive.board.inquiry.dao;

import com.lucete.comprehensive.board.inquiry.dto.CommDTO;
import com.lucete.comprehensive.board.inquiry.dto.InquiryDTO;
import com.lucete.comprehensive.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface InquiryMapper {

    int selectTotalCount(Map<String, String> searchMap);
    List<InquiryDTO> selectInquiryList(SelectCriteria selectCriteria);

    void insertInquiry(InquiryDTO inquiry);

    InquiryDTO selectInquiryDetail(int inquiryNo);

    void deleteInquiry(int inquiryNo);

    void updateInquiry(InquiryDTO inquiryNo);

//    void insertComm(CommDTO registComm);
//
//    List<CommDTO> selectCommList(CommDTO loadComm);
//
//    void deleteComm(CommDTO removeComm);




    /* ------ 관리자 페이지 ------*/
    int AdminSelectTotalCount(Map<String, String> searchMap);

    List<InquiryDTO> AdminSelectInquiryList(SelectCriteria selectCriteria);

    InquiryDTO AdminSelectInquiryDetail(int inquiryNo);

    void deleteAdminInquiry(int inquiryNo);

    /* 답변 */
    CommDTO searchCommDetail(int commKey);

    void insertComm(CommDTO comm);
}




