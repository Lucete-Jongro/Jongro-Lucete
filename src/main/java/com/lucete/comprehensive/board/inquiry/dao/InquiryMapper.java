package com.lucete.comprehensive.board.inquiry.dao;

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


}

