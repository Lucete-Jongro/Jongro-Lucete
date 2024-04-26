package com.lucete.comprehensive.user.admin.controller;

import com.lucete.comprehensive.user.blacklist.model.dto.BlacklistDTO;
import com.lucete.comprehensive.user.blacklist.model.service.BlacklistService;
import com.lucete.comprehensive.user.member.model.dto.MemberDTO;
import com.lucete.comprehensive.user.member.model.dto.SignInDTO;
import com.lucete.comprehensive.user.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    private BlacklistService blacklistService;
    @GetMapping("/userCategory")
    public void userCategory() {}
    @GetMapping("/updateBlacklist")
    public void updateBlacklist(){}
//    @PostMapping("/updateBlacklist")
//    public void updateBlacklist(){}

//    @GetMapping("/blacklist")
//    public void blacklist(){}

    @GetMapping("/userInfo")
    public String userInfo(Model model) {
        List<MemberDTO> allMembers = memberService.getAllMembers();
        model.addAttribute("members", allMembers);
        return "admin/userInfo";
    }

    @PostMapping("/userinfo")
    public List<MemberDTO> userInfo(@RequestParam("memName") String memName,
                                    @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                    @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                    @RequestParam("address") String address) {
        List<MemberDTO> memberDTO = memberService.selectMembers(memName, address, startDate, endDate);

        return memberDTO;
    }
    @GetMapping("/blacklist")
    public String showBlacklist(Model model) {
        List<BlacklistDTO> blacklist = blacklistService.getAllBlacklistedMembers();
        model.addAttribute("blacklist", blacklist);
        return "admin/blacklist";
    }


}