package com.lucete.comprehensive.board.inquiry.service;

import com.lucete.comprehensive.board.inquiry.dao.InquiryMapper;
import com.lucete.comprehensive.board.inquiry.dto.InquiryDTO;
import com.lucete.comprehensive.common.paging.Pagenation;
import com.lucete.comprehensive.common.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class InquiryService {

    private final InquiryMapper inquiryMapper;

    public InquiryService(InquiryMapper inquiryMapper) {
        this.inquiryMapper = inquiryMapper;
    }



    public Map<String,Object> selectInquiryList(Map<String, String> searchMap, int page){
        /* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리를 위해 */
        int totalCount = inquiryMapper.selectTotalCount(searchMap);
        log.info("inquiryList totalCount : {}", totalCount);

        /* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
        int limit = 10;
        int buttonAmount= 3;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit,buttonAmount, searchMap);
        log.info("inquiryList selectCriteria : {}", selectCriteria);

        /* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */

        List<InquiryDTO> inquiryList = inquiryMapper.selectInquiryList(selectCriteria);
        log.info("inquiryList : {}", inquiryList);

        Map<String, Object> inquiryListPaging = new HashMap<>();
        inquiryListPaging.put("paging", selectCriteria);
        inquiryListPaging.put("inquiryList", inquiryList);


        return inquiryListPaging;

    }

    public void registInquiry(InquiryDTO inquiry){
        /* 게시글 등록 */
        inquiryMapper.insertInquiry(inquiry);

    }

    public InquiryDTO selectInquiryDetail(int inquiryNo){
        /*게시글 상세 내용 조회 */
        return inquiryMapper.selectInquiryDetail(inquiryNo);
    }

    public void deleteInquiry(int inquiryNo) {
        /* 게시글 삭제 */
        inquiryMapper.deleteInquiry(inquiryNo);


        //회원 로그인 되면 회원만 삭제 접근 하는 기능 넣어야함

    }



}
