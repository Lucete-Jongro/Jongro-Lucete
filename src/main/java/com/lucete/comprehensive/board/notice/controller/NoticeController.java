package com.lucete.comprehensive.board.notice.controller;

import com.lucete.comprehensive.board.notice.model.dto.NoticeDTO;
import com.lucete.comprehensive.board.notice.model.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping
    public String getNoticeList(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(required = false) String searchCondition,
                                @RequestParam(required = false) String searchValue,
                                Model model) {

        log.info("noticeList page : {}", page);
        log.info("noticeList searchCondition : {}", searchCondition);
        log.info("noticeList searchValue : {}", searchValue);

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        Map<String, Object> noticeListAndPaging = noticeService.selectNoticeList(searchMap, page);
        model.addAttribute("paging", noticeListAndPaging.get("paging"));
        model.addAttribute("noticeList", noticeListAndPaging.get("noticeList"));

        return "notice/noticeList";
    }

    @GetMapping("/detail")
    public String getNoticeDetail(@RequestParam Long noticeNo, Model model){

        NoticeDTO noticeDetail = noticeService.selectNoticeDetail(noticeNo);
        log.info("noticeDetail : {}", noticeDetail);
        model.addAttribute("notice", noticeDetail);

        return "notice/noticeDetail";
    }

    @PostMapping("/removeNotice")
    public ResponseEntity<String> removeNotice(@RequestBody NoticeDTO removeNotice) {

        log.info("removeNotice no : {}", removeNotice.getNoitceNo());

        noticeService.removeNotice(removeNotice);

        return ResponseEntity.ok("공지사항 삭제 완료");

    }

    @GetMapping("/regist")
    public String getRegistPage() {
        return "notice/noticeRegist";
    }

    /* redirect를 사용하는 이유는 POST 요청 후에 브라우저를
    새로고침하거나 뒤로가기를 눌렀을 때 사용자에게
    "다시 제출하겠습니까?"와 같은 메시지를 보여주지 않고,
    해당 페이지로 다시 이동하게끔 만들기 위해서 */
    @PostMapping("/notice/regist")
    public String registNotice(@RequestBody NoticeDTO noticeDTO) {

        // 현재 날짜와 시간을 게시글 작성일로 설정합니다.
        noticeDTO.setNoticeDate(LocalDateTime.now());
        // 게시글 상태와 삭제 여부를 초기값으로 설정합니다.
        noticeDTO.setNoticeStatus('A'); // 'A'는 활성 상태를 나타냅니다.
        noticeDTO.setNoticeDeleteStatus('N'); // 'N'은 삭제되지 않은 상태를 나타냅니다.

        // 필요한 경우 추가 로직을 여기에 추가할 수 있습니다.

        // 받은 noticeDTO를 로깅합니다. (선택 사항)
        System.out.println("받은 noticeDTO: " + noticeDTO);

        // 등록된 게시글을 서비스 메소드를 호출하여 등록합니다.
        noticeService.registNotice(noticeDTO);

        // 등록 후에는 리스트 페이지로 리다이렉트합니다.
        return "redirect:/notice/list";
    }































}
