package com.lucete.comprehensive.user.member.controller;

import com.lucete.comprehensive.user.member.model.dto.SignUpDTO;
import com.lucete.comprehensive.user.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping("/user")
public class MemberController {
    @Autowired
    private MemberService memberService;



    @GetMapping("/signup")
    public void signup() {}

    @PostMapping("/signup")
    public ModelAndView signup(ModelAndView mv, @ModelAttribute SignUpDTO signupDTO) {

        System.out.println("signup 컨트롤러 작동");
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

    /* 아이디 중복 체크 : 비동기 통신
     * ResponseEntity : 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스
     * (HttpStatus, HttpHeaders, HttpBody 를 포함한다)
     * 규약에 맞는 HttpResponse를 반환하는데 사용 목적이 있다. */
    @PostMapping("/idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody SignUpDTO member) {

        log.info("Request Check ID : {}", member.getMemId());

        String result = "사용 가능한 아이디입니다.";

        if(memberService.selectMemberById(member.getMemId())) {
            result = "중복 된 아이디가 존재합니다.";
        }

        return ResponseEntity.ok(result);

    }
}

