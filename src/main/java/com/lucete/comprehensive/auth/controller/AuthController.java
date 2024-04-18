package com.lucete.comprehensive.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public void login() {}


    @GetMapping
    public void mypage(){}
    @GetMapping("/fail")
    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {
        mv.addObject("message", message);
        mv.setViewName("/auth/fail");
        return mv;
    }


        @GetMapping("/user/signup")
        public String showSignupForm() {
            return "signup"; // Thymeleaf 템플릿 이름을 반환합니다. 여기서는 "signup.html"이라고 가정합니다.

        }


}
