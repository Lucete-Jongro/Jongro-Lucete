package com.lucete.comprehensive.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "index"; // 메인 페이지의 HTML 파일명 또는 경로를 반환합니다.
    }
}