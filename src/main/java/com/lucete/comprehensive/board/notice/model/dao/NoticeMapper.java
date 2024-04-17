package com.lucete.comprehensive.board.notice.model.dao;

import com.lucete.comprehensive.board.notice.model.dto.NoticeDTO;
import com.lucete.comprehensive.common.paging.SelectCriteria;

import java.util.List;
import java.util.Map;

public interface NoticeMapper {
    int selectTotalCount(Map<String, String> searchMap);

    List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

    void incrementNoticeCount(Long noticeNo);

    NoticeDTO selectNoticeDetail(Long noticeNo);
}
