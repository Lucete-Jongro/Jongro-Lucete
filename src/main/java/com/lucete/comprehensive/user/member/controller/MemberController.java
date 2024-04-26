package com.lucete.comprehensive.user.member.controller;

import com.lucete.comprehensive.auth.model.AuthDetails;
import com.lucete.comprehensive.auth.model.service.AuthService;
import com.lucete.comprehensive.user.member.model.dto.MemberDTO;
import com.lucete.comprehensive.user.member.model.dto.SignInDTO;
import com.lucete.comprehensive.user.member.model.dto.SignUpDTO;
import com.lucete.comprehensive.user.member.model.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

@Controller
@Slf4j
@RequestMapping("/user")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private AuthService authService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/mypage/orderlist")
    public void orderlist(){

    }
    @GetMapping("/mypage")
    public void mypage(){}
    @GetMapping("/mypage/myinfo")
    public void myinfo(){}
    @GetMapping("/findid")
    public void findid(){}

    @GetMapping("/mypage/changepwd")
    public void changepwd(){}

    @GetMapping("/mypage/updateEmail")
    public void updateEmail(){}
    @PostMapping("/mypage/updateEmail")
    public void updateEmail(@RequestParam("email") String email, HttpSession session){
        // 세션에서 현재 사용자의 회원 번호 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // 구세주다 정말........!!!!!!!!!!!!!!!!!!!!!
        System.out.println(username);

        // 이메일 업데이트 메서드 호출
        memberService.updateEmail(username, email);
    }

    @PostMapping("/findid")
    public String findId(@RequestParam("memName") String memName,
                         @RequestParam("phone") String phone,
                         Model model) {
        String result = memberService.findId(memName, phone);
        if (result == null) {
            result = "해당하는 아이디가 없습니다.";
        }
        model.addAttribute("result", result);
        return "user/findid"; // 타임리프 템플릿 이름 반환
    }
    @GetMapping("findpwd")
    public void findpwd(){}


    @GetMapping("/signup")
    public void signup(){}

    @PostMapping("/signup")
    public ModelAndView signup(ModelAndView mv, @ModelAttribute SignUpDTO signupDTO) {

        System.out.println("signup 컨트롤러 작동");
        int result = memberService.regist(signupDTO);

        String message = "";

        if (result > 0) {
            message = "회원가입이 정상적으로 완료되었습니다.";

            AuthDetails authDetails = new AuthDetails(signupDTO);
            Authentication authentication = new UsernamePasswordAuthenticationToken(authDetails, null, authDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

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
        System.out.println(Objects.isNull(member));

        log.info("Request Check ID : {}", member.getMemId());

        String result = "사용 가능한 아이디입니다.";


        if(memberService.selectMemberById(member.getMemId())) {
            result = "중복 된 아이디가 존재합니다.";

        }

        return ResponseEntity.ok(result);

    }


        @PostMapping("/mypage")
        public String myPage(Model model) {
            // Spring Security에서 사용자 정보를 가져옵니다.
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            // 인증된 사용자 정보를 가져옵니다.
            AuthDetails userDetails = (AuthDetails) authentication.getPrincipal();
            // 사용자의 이름을 모델에 추가합니다.
            model.addAttribute("memName", userDetails.getUsername());
            model.addAttribute("email",userDetails.getEmail());

            return "mypage"; // 마이페이지 뷰로 이동합니다.
        }


    @GetMapping("/changePassword")
    public String showChangePasswordForm() {
        return "changePasswordForm";
    }



    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @AuthenticationPrincipal UserDetails userDetails,
                                 Model model) {
        String memId = userDetails.getUsername(); // 사용자 아이디 가져오기

        if (!passwordEncoder.matches(currentPassword, userDetails.getPassword())) {
            model.addAttribute("error", "Current password is incorrect");
            return "changePasswordForm";
        }

        memberService.changePassword(memId, newPassword); // 사용자 아이디와 새로운 비밀번호 전달

        return "redirect:/mypage";
    }


}

