package com.shinhan.myapp.controller2;

import com.shinhan.myapp.vo.ParamVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/friday")
@Slf4j
public class Friday {

    @RequestMapping(value = "/one.do", method = RequestMethod.GET)
    public void f1() {

    }

    /**
     * 1. 하나의 input받기: String username
     * 2. VO로 받기: ParamVO param
     * 3. map받기: @RequestParam Map<String, String > map
     *            map은 @RequestParam 필수
     */

    @GetMapping("/two.do")
    public String f2(
            @RequestParam Map<String, String > map,
            ParamVO param,
            @RequestParam(value = "userid", required = false) Integer userid2) {
        log.info("userid" + userid2);
        log.info("paramVO" + param.toString());
        log.info("map" + map);
        return "redirect:/dept/list.do";
    }
}