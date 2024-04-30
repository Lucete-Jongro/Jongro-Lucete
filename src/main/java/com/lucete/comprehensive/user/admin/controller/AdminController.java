package com.lucete.comprehensive.user.admin.controller;

import com.lucete.comprehensive.user.member.model.dto.MemberDTO;
import com.lucete.comprehensive.user.member.model.dto.SignInDTO;
import com.lucete.comprehensive.user.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/userCategory")
    public void userCategory() {}

    @GetMapping("/userInfo")
    public void userInfo() {}

    @PostMapping("/userinfo")
    public List<MemberDTO> userInfo(@RequestParam("memName") String memName,
                                    @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                    @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                    @RequestParam("address") String address) {
        List<MemberDTO> memberDTO = memberService.selectMembers(memName, address, startDate, endDate);
        return memberDTO;
    }
}