package com.lucete.comprehensive.board.inquiry.controller;

import com.lucete.comprehensive.board.inquiry.service.InquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

         return "inquiryList";

     }
     @GetMapping("/regist")
     public String getRegistPage(){
        return "inquiry/inquiryRegist";
     }

//     @PostMapping("regist")
//    public String registInquiry(InquiryDTO inquiry, @AuthenticationPrincipal MemberDTO member) {
//
//        inquiry.setMemNo(member);
//        log.info("registInquiry inquiry : {}", inquiry);
//
//        inquiryService.registInquiry(inquiry);
//
//        return "redirect:/inquiry/list";
//     }







}
