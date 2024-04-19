package com.lucete.comprehensive.user.member.controller;

import com.lucete.comprehensive.auth.model.service.AuthService;
import com.lucete.comprehensive.user.member.model.dto.SignUpDTO;
import com.lucete.comprehensive.user.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping("/user")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private AuthService authService;
    @GetMapping("/mypage")
    public void mypage(){}
    @GetMapping("/findid")
    public void findid(){}

    @PostMapping("/findid")
    public ModelAndView findId(ModelAndView mv, @RequestParam("email") String email) {
        // 이메일 주소를 이용하여 아이디를 찾는 로직을 구현
        String foundId = memberService.findMemberIdByEmail(email);

        String message = "";
        if (foundId != null) {
            message = "회원님의 아이디는 " + foundId + " 입니다.";
            mv.setViewName("auth/login"); // 아이디를 찾은 후 로그인 페이지로 이동
        } else {
            message = "입력하신 이메일로 등록된 회원이 없습니다.";
            mv.setViewName("user/findid"); // 아이디를 찾지 못한 경우 다시 아이디 찾기 페이지로 이동
        }

        mv.addObject("message", message);

        return mv;
    }
    @GetMapping("/findpwd")
    public void findpwd(){}
    @PostMapping("/findpwd")
    public ModelAndView findPassword(ModelAndView mv, @RequestParam("email") String email) {
        // 이메일 주소를 이용하여 비밀번호를 찾는 로직을 구현
        String foundPassword = memberService.findMemberPasswordByEmail(email);

        String message = "";
        if (foundPassword != null) {
            message = "회원님의 비밀번호는 " + foundPassword + " 입니다.";
            mv.setViewName("auth/login"); // 비밀번호를 찾은 후 로그인 페이지로 이동
        } else {
            message = "입력하신 이메일로 등록된 회원이 없습니다.";
            mv.setViewName("user/find-password"); // 비밀번호를 찾지 못한 경우 다시 비밀번호 찾기 페이지로 이동
        }

        mv.addObject("message", message);

        return mv;
    }
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

@PostMapping
    protected Authentication createNewAuthentication(String memberId) {

    UserDetails newPrincipal = authService.loadUserByUsername(memberId);
        UsernamePasswordAuthenticationToken newAuth
                = new UsernamePasswordAuthenticationToken(newPrincipal, newPrincipal.getPassword(), newPrincipal.getAuthorities());

        return newAuth;
    }
}

