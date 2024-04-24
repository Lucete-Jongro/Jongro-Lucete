package com.lucete.comprehensive.auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

    @PostMapping("/login")
    public void login(@RequestParam("memName") String username, @RequestParam("password") String password, HttpSession session, int memNo) {
        // 사용자 인증 및 로그인 처리 로직

        // 인증에 성공하면 세션에 사용자 정보 설정
        session.setAttribute("memName", username); // 세션에 사용자 이름 저장
        session.setAttribute("password",password);
        session.setAttribute("memNo",memNo);

    }
    @GetMapping("/logout")
    public void logout(){}



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
