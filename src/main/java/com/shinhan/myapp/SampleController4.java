package com.shinhan.myapp;

import com.shinhan.myapp.vo.DeptDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController4 {

    Logger logger = LoggerFactory.getLogger(SampleController4.class);

    @GetMapping("/jsptest2/coffee.do")
    public void f1() {

    }

//@RequestParam: requdestw
    @GetMapping("/jsptest2/coffee2.do")
    public void f2(@RequestParam("department_id") int id,
                   @RequestParam("department_name") String name,
                   @RequestParam("manager_id") int mid,
                   @RequestParam("location_id") int locid) {
        logger.info("id = " + id);
        logger.info("name = " + name);
        logger.info("mid = " + mid);
        logger.info("locid = " + locid);
    }

//model.addAttribute
    @GetMapping("/jsptest2/coffee3.do")
    public String f3 (@ModelAttribute DeptDTO dept) {
        logger.info((dept.toString()));
        return "jsptest2/coffe2;";
    }
}
