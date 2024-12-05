package com.shinhan.myapp.contoller;

import com.shinhan.myapp.model.DeptService;
import com.shinhan.myapp.vo.DeptDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

//부서의 CRUD 작업: Controller -> Service -> DAO
//Client(Browser) -> Dispatcher Servlet -> Controller -> Service -> Repository
//componenet-scan에 의해 Bean생성

//Controller: 요청을 받아서 응답페이지를 return
//RestController: 요청을 받아서 데이터를 return  @Controller + @ResponseBody
@Controller
//@RestController  //@Controller + ResponseBody
public class DeptController {

    @Autowired
    DeptService deptService;
    Logger logger = LoggerFactory.getLogger(DeptController.class);

    @GetMapping("dept/detail.do")
    public String detail(int deptid, Model model){
        model.addAttribute("deptDTO", deptService.selectByIdService(deptid));
        return "dept/deptDetail";
    }


    /* 상세보기 후에 결과를 보여주고 1초 후 list로 가기
    @PostMapping("dept/detail.do")
    public String detailPost(@ModelAttribute("dept") DeptDTO dept){
        logger.info(dept.toString());
        deptService.updateService(dept);
        return "dept/result";
    }
    */

    @PostMapping("dept/detail.do")
    public String detailPost(DeptDTO dept, RedirectAttributes attr){
        logger.info(dept.toString());
        int result = deptService.updateService(dept);
        String message = "수정건수: " + result;
        attr.addFlashAttribute("resultMessage", message);

        return "redirect:/dept/list.do";
    }

    //d@ResponseBody  //request.getWriter().append("aaa");
    @RequestMapping("/dept/list.do")
    public String  selectAllList(Model model, HttpServletRequest request) {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        if (map != null) {
            String message = (String) map.get("resultMessage");
            model.addAttribute("result", message);
        }
        List<DeptDTO> deptList = deptService.selectAllService();
        model.addAttribute("deptList", deptList);
        return "dept/deptList";  //forward, include
        // prefix: /WEB-INF/views/"
        // suffix: .jsp"
    }

    @GetMapping("/dept/insert.do")
    public String insertGet() {
        return "dept/deptInsert";
    }

    @PostMapping("/dept/insert.do")
    public String insertPost(DeptDTO dept, RedirectAttributes attr) {
        int result = deptService.insertService(dept);
        String message = "입력건수:" + result;
        logger.info(message);
        attr.addFlashAttribute("resultMessage", message);
        return "redirect:/dept/list.do";
    }

    @RequestMapping(value = "/dept/delete.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String delete(@RequestParam("deptid") int deptid, RedirectAttributes attr) {
        int result = deptService.deleteService(deptid);
        String message = "삭제건수: " + result;
        attr.addFlashAttribute("resultMessage", message);
        return "redirect:/dept/list.do";
    }

}
