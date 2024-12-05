package com.shinhan.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//여러가지 형태의 요청 학습
@Controller
public class SampleController3 {

    Logger logger = LoggerFactory.getLogger(SampleController3.class);

    //요청의 주소 같고, 넘어오는 파라메터도 확인
    //(userid라는 파라메터의 값은 꼭 같아야함. userpw는 존재하기만 하면됨, email은 존재안함)
    @RequestMapping(value="/second4.do", params = {"userid=jamm", "userpw", "!email"})
    public String f3(String userid, String userpw) {
        logger.info("id= " + userid);
        logger.info("pw= " + userpw);
        return "jsptest/second3";
    }

    @RequestMapping(value = {"/second3.do"}, method= RequestMethod.POST)
    public String f2(@RequestParam("userid") String userid2,
                     @RequestParam("userpw") int userpw) {
        logger.info("id= " + userid2);
        logger.info("pw= " + userpw);
        return "jsptest/second3";
    }

    @RequestMapping(value = {"/second1.do","/second2.do"}, method= RequestMethod.GET)
    public String f1() {
        return "/jsptest/first1";
    }
}
