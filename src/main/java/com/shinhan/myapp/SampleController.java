package com.shinhan.myapp;

import com.shinhan.myapp.model.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller  //요청오면 페이지 return, 다른 요청으로 재요청 가능
public class SampleController {

    @Autowired
    DeptService deptService;

    //3. View 이름 return
    @RequestMapping(value = "/test2.do", method = RequestMethod.GET)
    public String f2(Model model) {
        model.addAttribute("dept", deptService.selectByIdService(60));
        return "jsptest/test2";
    }

    //2. ModelAndView 리턴 (Model + View)
    @RequestMapping(value = "/test3.do", method = RequestMethod.GET)
    public ModelAndView f3(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("dept", deptService.selectByIdService(80));
        mv.setViewName("jsptest/test2");
        return mv;
    }

    //요청주소와 페이지의 위치가 같으면 페이지이름은 setting 하지 않아도됨.
    @RequestMapping(value = "/jsptest/test2.do", method = RequestMethod.GET)
    public void f4(Model model) {
        model.addAttribute("dept", deptService.selectByIdService(90));
    }

    @RequestMapping("/test1.do")
    public String f1(Model dataStore) {
        dataStore.addAttribute("myname", "evan");
        dataStore.addAttribute("score", "99");
        return "jsptest/test1";
    }
}
