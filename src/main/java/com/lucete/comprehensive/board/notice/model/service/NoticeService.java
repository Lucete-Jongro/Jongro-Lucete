package com.lucete.comprehensive.board.notice.model.service;

import com.lucete.comprehensive.board.notice.model.dao.NoticeMapper;
import com.lucete.comprehensive.board.notice.model.dto.NoticeDTO;
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
public class NoticeService {

    private final NoticeMapper noticeMapper;

    /*(석현) 의존성 주입이다. @Autowired가 생략된 것이다. */
    public NoticeService(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public Map<String, Object> selectNoticeList(Map<String, String> searchMap, int page) {

        int totalCount = noticeMapper.selectTotalCount(searchMap);
        log.info("noticeList totalCount : {}", totalCount);

        /* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
        int limit = 10;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
        log.info("noticeList selectCriteria : {}", selectCriteria);

        /* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
        List<NoticeDTO> noticeList = noticeMapper.selectNoticeList(selectCriteria);
        log.info("noticeList : {}", noticeList);

        Map<String, Object> noticeListAndPaging = new HashMap<>();
        noticeListAndPaging.put("paging", selectCriteria);
        noticeListAndPaging.put("noticeList", noticeList);

        return noticeListAndPaging;


    }
    
    public NoticeDTO selectNoticeDetail(Long noticeNo) {

        /* 조회수 증가 로직 호출 */
        noticeMapper.incrementNoticeCount(noticeNo);

        /* 게시글 상세 내용 조회 후 리턴 */
        return noticeMapper.selectNoticeDetail(noticeNo);


    }

    public void removeNotice(NoticeDTO removeNotice) {
    }
}
