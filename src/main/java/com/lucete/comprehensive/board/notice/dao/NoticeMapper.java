package com.lucete.comprehensive.board.notice.dao;

import com.lucete.comprehensive.board.notice.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
    List<NoticeDTO> getALlNotice();

    List<NoticeDTO> getSearchNotice(Map<String, String> searchMap);


    void registNotice(Map<String, String> registMap);
}
