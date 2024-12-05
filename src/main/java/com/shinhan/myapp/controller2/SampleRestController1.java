package com.shinhan.myapp.controller2;

import com.shinhan.myapp.emp.EmpDTO;
import com.shinhan.myapp.emp.EmpService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//Spring3 version: @Controller + @ResponseBody
@Controller
@ResponseBody
@RequestMapping("/rest")
public class SampleRestController1 {

    private final EmpService empService;

    public SampleRestController1(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping(value = "/test1.do", produces = "text/plain;charset=utf-8")
    public String f1() {
        return "rest방식 연습1";
    }
}
