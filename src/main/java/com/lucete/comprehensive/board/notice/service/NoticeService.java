package com.lucete.comprehensive.board.notice.service;

import com.lucete.comprehensive.board.notice.dao.NoticeMapper;
import com.lucete.comprehensive.board.notice.dto.NoticeDTO;
import org.springframework.stereotype.Service;

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
}
