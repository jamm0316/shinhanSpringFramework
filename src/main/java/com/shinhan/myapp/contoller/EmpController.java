package com.shinhan.myapp.contoller;

import com.shinhan.myapp.emp.EmpDTO;
import com.shinhan.myapp.emp.EmpJoinDTO;
import com.shinhan.myapp.emp.EmpService;
import com.shinhan.myapp.model.AccountService;
import com.shinhan.myapp.model.DeptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @RequiredArgsConstructor -> final인 변수들의 생성자 생성
 */

@Slf4j
@Controller
@RequestMapping("/emp")
@RequiredArgsConstructor  //final + @Autowired
public class EmpController {

    final EmpService empService;
    final DeptService deptService;
    final AccountService accountService;

    @ResponseBody  //응답문서를 만들어서 data를 보낼때 사용(즉, page없음, REST API) == response.getWriter().append("")
    @GetMapping(value = "/transfer.do", produces = "text/plain;charset=utf-8")
    public String transfer() {
        accountService.transferService();
        return "이체서비스 완료";
    }

//    @GetMapping("/listByArray.do")
//    public String listByArray(@RequestParam(value = "deptArr[]") Integer[] arr, Model model) {
//        //배열을 list로 변경하기
//        model.addAttribute("emplist",
//                empService.selectByArray(Arrays.asList(arr)));
//        return "emp/empListTable";
//    }

    //여기수정*******************************
    @RequestMapping("/list.do")
    public String selectEmp(Model model, HttpServletRequest request) {
        model.addAttribute("joblist", empService.selectAllJobsService());
        model.addAttribute("deptlist", deptService.selectAllService());
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        if (map != null) {
            String message = (String) map.get("resultMessage");
            model.addAttribute("resultMessage", message);
        }
        return "emp/empList";
    }
    //여기수정*******************************

    @RequestMapping("/list2.do")
    public String selectCondition(
            Model model,
            @RequestParam Map<String, Object> map) {
        String chk = (String) map.get("chk");

        if (chk.equals("true") || chk.equals("false")) {
            map.put("hdate", "1900-01-01");
        }
        System.out.println(map);
        List<EmpDTO> emplist = empService.selectByCondition(map);
        model.addAttribute("emplist", emplist);
        return "emp/empListTable";
    }

    @GetMapping("/insert.do")
    public String insertGet(Model model) {
        model.addAttribute("joblist", empService.selectAllJobsService());
        model.addAttribute("deptlist", deptService.selectAllService());
        model.addAttribute("managerlist", empService.selectAllService());
        return "emp/empInsert";
    }

    //여기수정*******************************
    @PostMapping("/insert.do")
    public String insertPost(EmpDTO emp, RedirectAttributes attr) {
        int result = empService.insertEmp(emp);
        attr.addFlashAttribute("resultMessage", result > 0 ? "입력 성공" : "입력 실패");
        return "redirect:list.do";
    }
    //여기수정*******************************

    @GetMapping("/detail.do")
    public String detailGet(int empid, Model model) {
        model.addAttribute("empDTO", empService.selectByIdService(empid));
        model.addAttribute("joblist", empService.selectAllJobsService());
        model.addAttribute("deptlist", deptService.selectAllService());
        model.addAttribute("managerlist", empService.selectAllService());
        return "emp/empDetail";
    }

    //여기수정*******************************
    @PostMapping("/detail.do")
    public String detailPost(EmpDTO emp, RedirectAttributes attr) {
        int result = empService.updateService(emp);
        attr.addFlashAttribute("resultMessage", result > 0 ? "수정 성공" : "수정 실패");
        return "redirect:list.do";
    }

    @RequestMapping(value = "/delete.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteEmp(int empid, RedirectAttributes attr) {
        int result = empService.deleteService(empid);
        attr.addFlashAttribute("resultMessage", result > 0 ? "삭제 성공" : "삭제 실패");
        return "redirect:list.do";
    }

    @GetMapping("/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:list.do";
    }

    @GetMapping("/listBySalary.do")
    public String listBySalary(double salary, Model model) {
        List<EmpDTO> emplist = empService.selectBySalary(salary);
        model.addAttribute("emplist", emplist);
        return "emp/empListTable";
    }

    @GetMapping("/listByJob.do")
    public String listByJob(String jobid, Model model) {
        List<EmpDTO> emplist = empService.selectByJob(jobid);
        model.addAttribute("emplist", emplist);
        return "emp/empListTable";
    }

    @GetMapping("/listByDept.do")
    public String listByDept(int deptid, Model model) {
        List<EmpDTO> emplist = empService.selectByDept(deptid);
        model.addAttribute("emplist", emplist);
        return "emp/empListTable";
    }

    @GetMapping("/listByJobJoin.do")
    public String listByJobJoin(String jobid, Model model) {
        List<EmpJoinDTO> emplist = empService.selectByJobJoin(jobid);
        model.addAttribute("emplist", emplist);
        return "emp/empListTable2";
    }

    @GetMapping("/listByJobJoin2.do")
    public String listByJobJoin2(String jobid, Model model) {
        log.info("parameter job: " + jobid);
        List<Map<String, Object>> emplist = empService.selectByJobJoin3(jobid);
        log.info("emplist: " + emplist.toString());
        model.addAttribute("emplist", emplist);
        return "emp/empListTable2";
    }
}
