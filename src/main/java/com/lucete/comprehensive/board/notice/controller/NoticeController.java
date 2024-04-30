package com.lucete.comprehensive.board.notice.controller;

import com.lucete.comprehensive.board.notice.dto.NoticeDTO;
import com.lucete.comprehensive.board.notice.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/admin")
    public String adminNoticePage(Model model) {
        List<NoticeDTO> noticeList = noticeService.getAllNotice();

        model.addAttribute("noticeList", noticeList);
        return "notice/admin/noticeManagement";
    }

    @PostMapping("/admin/search")
    public String searchCriteria(@RequestParam(required = false) String searchConditionColumn,
                                 @RequestParam(required = false) String searchConditionCategory,
                                 @RequestParam(required = false) String searchValue,
                                 @RequestParam(required = false) String searchStartDate,
                                 @RequestParam(required = false) String searchEndDate,
                                 Model model) {


        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchConditionColumn", searchConditionColumn);
        System.out.println("searchConditionColumn : " + searchMap.get("searchConditionColumn"));

        searchMap.put("searchConditionCategory", searchConditionCategory);
        System.out.println("searchConditionCategory : " + searchMap.get("searchConditionCategory"));

        searchMap.put("searchValue", searchValue);
        System.out.println("searchValue : " + searchMap.get("searchValue"));

        searchMap.put("searchStartDate", searchStartDate);
        searchMap.put("searchEndDate", searchEndDate);
        System.out.println("searchStartDate : " + searchMap.get("searchStartDate"));
        System.out.println("searchEndDate : " + searchMap.get("searchEndDate"));


        List<NoticeDTO> searchResults = noticeService.getSearchNotice(searchMap);
        System.out.println("===================" + searchResults);
        model.addAttribute("noticeList", searchResults);

        return "notice/admin/noticeSearchList";
    }

    @GetMapping("/admin/regist")
    public String getRegist(Model model) {
        model.addAttribute("selectConditionCategory", "일반");
        model.addAttribute("noticeTitle", "제목을 입력하세요.");
        model.addAttribute("noticeContent", "텍스트");

        return "notice/admin/noticeRegist.html";
    }

    @PostMapping("/admin/regist")
    public String registNotice(@RequestParam String selectConditionCategory,
                               @RequestParam String noticeTitle,
                               @RequestParam String noticeContent,
                               Model model) {

        Date nowDate = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String registDate = sdf.format(nowDate);

        Map<String, String> registMap = new HashMap<>();
        registMap.put("selectConditionCategory", selectConditionCategory);
        registMap.put("noticeTitle", noticeTitle);
        registMap.put("noticeContent", noticeContent);
        registMap.put("registDate", registDate);

        System.out.println("selectConditionCategory : " + selectConditionCategory);
        System.out.println("noticeTitle : " + noticeTitle);
        System.out.println("noticeContent : " + noticeContent);

        noticeService.registNotice(registMap);

        return "redirect:/notice/admin";
    }

    @GetMapping("/user")
    public String userNoticePage(Model model,
                                 @RequestParam(defaultValue = "1") int page,
                                 @RequestParam(required = false) String searchCondition,
                                 @RequestParam(required = false) String searchValue) {

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        Map<String, Object> noticeListAndPaging = noticeService.selectNoticeList(searchMap, page);
        model.addAttribute("paging", noticeListAndPaging.get("paging"));

        model.addAttribute("noticeList", noticeListAndPaging.get("noticeList"));

        return "/notice/user/noticeMainView";
    }

    @GetMapping("/user/view")
    public String viewDetailNotice(Model model,
                                   @RequestParam int noticeNo) {

        List<NoticeDTO> noticeList = noticeService.getDetailNotice(noticeNo);

        model.addAttribute("noticeList",noticeList);

        return "/notice/user/noticeDetailView";

    }
}
