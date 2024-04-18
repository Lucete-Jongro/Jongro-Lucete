package com.lucete.comprehensive.board.inquiry.controller;

import com.lucete.comprehensive.board.inquiry.dto.InquiryDTO;
import com.lucete.comprehensive.board.inquiry.service.InquiryService;
import com.lucete.comprehensive.user.member.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/inquiry")
public class InquiryController {

   // private static final Logger logger = LoggerFactory.getLogger(InquiryController.class);


    private final InquiryService inquiryService;


    @Autowired
    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    /* 문의글 리스트 조회 */
     @GetMapping("/list")
    public String getInquiryList(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(required = false) String searchCondition,
                                 @RequestParam(required = false) String searchValue,
                                 Model model) {

        log.info("inquiryList page : {}", page);
        log.info("inquiryList searchCondition : {}", searchCondition);
        log.info("inquiryList searchValue : {}", searchValue);

         Map<String,String> searchMap = new HashMap<>();
         searchMap.put("searchCondition", searchCondition);
         searchMap.put("searchValue", searchValue);

         Map<String, Object> inquiryListAndPaging = inquiryService.selectInquiryList(searchMap,page);
         model.addAttribute("paging", inquiryListAndPaging.get("paging"));
         model.addAttribute("inquiryList", inquiryListAndPaging.get("inquiryList"));
         return "inquiry/inquiryList";

     }
     @GetMapping("/regist")
     public String getRegistPage(){

        return "inquiry/inquiryRegist";
     }

    /*소비자 문의글 등록 */
     @PostMapping("/regist")
    public String registInquiry(InquiryDTO inquiry) {

        //inquiry.setMemNo(member);
        log.info("registInquiry inquiry : {}", inquiry);

         MemberDTO memberDTO = new MemberDTO();

         inquiry.setMemNo(memberDTO.getMemNo());
         System.out.println("되니!!!!!!!!!!!!!!!!!!!" + inquiry.getMemNo());
         inquiry.setMemName(memberDTO.getMemName());
         System.out.println("되니!@@@@@@@@@@@@@@" + inquiry.getMemName());

        inquiryService.registInquiry(inquiry);

        return "redirect:/inquiry/list";
     }

     /*소비자 문의글 상세 보기 */
     @GetMapping("/detail")
    public String getInquiryDetail(@RequestParam int inquiryNo, Model model) {

        InquiryDTO inquiryDetail = inquiryService.selectInquiryDetail(inquiryNo);
        log.info("inquiryDetail : {}", inquiryDetail);
        model.addAttribute("inquiry", inquiryDetail);

        return "inquiry/inquiryDetail";
     }

     /* 소비자 문의글 삭제 */
     @RequestMapping("/delete")
     public String inquiryDelete(InquiryDTO inquiry) {

         inquiryService.deleteInquiry(inquiry.getInquiryNo());

         return "redirect:/inquiry/list";

     }

     /* 업데이트 페이지 반환*/
    @GetMapping("/update/{inquiryNo}")
    public String inquiryEdit(@PathVariable("inquiryNo") int inquiryNo, Model model){

        model.addAttribute("inquiry",inquiryService.selectInquiryDetail(inquiryNo));

        return "/inquiry/inquiryUpdate";
    }

     /* 소비자 문의글 수정 페이지 */
    @PostMapping("/update/{inquiryNo}")
    public String inquiryUpdate(@PathVariable("inquiryNo") int inquiryNo, InquiryDTO inquiry) {

        /*현재의 문의글을 반환*/
        InquiryDTO inquiryTemp = inquiryService.selectInquiryDetail(inquiryNo);

        /*수정 내용 덮기*/
        inquiryTemp.setInquiryTitle(inquiry.getInquiryTitle());
        System.out.println(inquiryTemp.getInquiryTitle());
        inquiryTemp.setInquiryContent(inquiry.getInquiryContent());

        /*업데이트 */
        inquiryService.updateInquiry(inquiryTemp);

        return "redirect:/inquiry/list";
    }








}
