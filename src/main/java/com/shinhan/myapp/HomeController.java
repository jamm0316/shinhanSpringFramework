package com.shinhan.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Spring은 POJO방식
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "home.do", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        Date date = new Date(); // "-"를 "="로 수정
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale); // 포맷 설정 완료

        String formattedDate = dateFormat.format(date); // 포맷된 날짜 문자열
        model.addAttribute("serverTime", formattedDate); // 올바른 메서드와 값 사용
        model.addAttribute("myName", "송재명"); // 올바른 메서드와 값 사용

        return "index"; // 반환 값 유지
    }
}
