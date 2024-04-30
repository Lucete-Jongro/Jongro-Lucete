package com.lucete.comprehensive.board.notice.service;

import com.lucete.comprehensive.board.notice.dao.NoticeMapper;
import com.lucete.comprehensive.board.notice.dto.NoticeDTO;
import com.lucete.comprehensive.common.paging.Pagenation;
import com.lucete.comprehensive.common.paging.SelectCriteria;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeService {
    private final NoticeMapper noticeMapper;
    public NoticeService(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public List<NoticeDTO> getAllNotice() {
        return noticeMapper.getALlNotice();
    }

    public List<NoticeDTO> getSearchNotice(Map<String, String> searchMap) {

        List<NoticeDTO> searchNoticeList = noticeMapper.getSearchNotice(searchMap);

        return searchNoticeList;
    }


    public void registNotice(Map<String, String> registMap) {
        noticeMapper.registNotice(registMap);
    }

    public Map<String, Object> selectNoticeList(Map<String, String> searchMap, int page) {

        /* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리를 위해 */
        int totalCount = noticeMapper.selectTotalCount(searchMap);

        /* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
        int limit = 10;
        int buttonAmount= 3;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit,buttonAmount, searchMap);

        /* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */

        List<NoticeDTO> noticeList  = noticeMapper.selectNoticeList(selectCriteria);

        Map<String, Object> noticeListPaging = new HashMap<>();
        noticeListPaging.put("paging", selectCriteria);
        noticeListPaging.put("noticeList", noticeList);

        return noticeListPaging;

    }

    public List<NoticeDTO> getDetailNotice(int noticeNo) {
        return noticeMapper.getDetailNotice(noticeNo);
    }
}
