package com.lucete.comprehensive.user.member.controller;

import com.lucete.comprehensive.user.member.model.dto.SignUpDTO;
import com.lucete.comprehensive.user.member.model.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
    @RequestMapping("/user")
    public class MemberController {
    private MemberService memberService;



        @GetMapping("/signup")
        public void signup() {}

        @PostMapping("/signup")
        public ModelAndView signup(ModelAndView mv, @ModelAttribute SignUpDTO signupDTO) {

            int result = memberService.regist(signupDTO);

            String message = "";

            if (result > 0) {
                message = "회원가입이 정상적으로 완료되었습니다.";
                mv.setViewName("auth/login");
            } else {
                message = "회원가입에 실패하였습니다.";
                mv.setViewName("user/signup");
            }

            mv.addObject("message", message);

            return mv;
        }
        @GetMapping("/regist")
        public void registPage(){}

    }

