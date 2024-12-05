package com.shinhan.myapp;

import com.shinhan.myapp.model.MemberService;
import com.shinhan.myapp.vo.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    MemberService memberService;
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login.do")
    public void loginPage() {}

    @GetMapping("/main.do")
    public void mainPage() {
    }

    @PostMapping("/login.do")
    public String loginPost(String uesrid, String userpass,
                            HttpServletRequest request,
                            HttpSession session) {
        logger.info(request.getRemoteAddr() + "에서 요청함");

        MemberDTO memberDTO = memberService.loginService(uesrid, userpass);
        if (memberDTO == null) {
            logger.info("아이디가 존재하지 않음");
        } else if (memberDTO.getMember_id().equals("ErrorPassWord")) {
            logger.info("비밀번호 틀림");
        } else {
            logger.info(memberDTO.toString());
            session.setAttribute("loginMember", memberDTO);
            return "redirect:/auth/main.do";
        }



        //다시 로그인
        return "redirect:/auth/login.do";
    }
}
