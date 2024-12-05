package com.shinhan.myapp.controller2;

import com.shinhan.myapp.emp.EmpDTO;
import com.shinhan.myapp.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Spring4 version: @RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/rest")
public class EmpRestController {

    @Autowired
    EmpService empService;

    //1. 들어온 data는 없음, 생산되는 data는 단순한 문자
    @GetMapping(value = "/test2.do", produces = "text/plain;charset=utf-8")
    public String f1() {
        EmpDTO empDTO = empService.selectByIdService(100);
        return "rest방식 연습2(4버전 @RestController): " + empDTO.getFirst_name();
    }

    //JSON형태의 예: {"키" : "값"}, {"키" : {"키" : 값}}
    //직원 조회
    //{"emplist":[{}, {}, {}]}
    //2. 들어온 data는 없음, return data JSON
    //Jackson라이브러리가 data를 JSON으로 변경해서 return한다.
    @GetMapping(value = "/emplist.do", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmpDTO> f2() {
        List<EmpDTO> emplist = empService.selectAllService();
        return emplist;
    }

    //3. HTTP URI를 통해서 들어온 data는 있음, return data JSON
    // 특정 직원조회
    @GetMapping(value = "/empdetail.do/{empid}", produces = "application/json")
    public EmpDTO f3(@PathVariable int empid) {
        EmpDTO empDTO = empService.selectByIdService(empid);
        return empDTO;
    }

    //4. 모든직원을 조회하고 return은 Map<키(직원번호), 값(직원 DTO)>
    @GetMapping(value = "/empmap.do", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, EmpDTO> f4() {
        Map<Integer, EmpDTO> map = new HashMap<>();
        List<EmpDTO> emplist = empService.selectAllService();
        emplist.forEach(emp -> {
            map.put(emp.getEmployee_id(), emp);
        });
        return map;
    }

    //5. 입력(post), 들어오는 data가 있음. data는 요청문서의 body로 온다.
    //** 주의: parameter 형식은 주소 창에 '키=값' 형태로 오는 것, restful 방식은 @Requestparam방식으로 오지 않는다.
    //        요청문서의 body로 온다.
    @PostMapping(value = "/empinsert.do",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "text/plain;charset=utf-8")
    public String insert(@RequestBody EmpDTO emp) {
        int result = empService.insertEmp(emp);
        return result > 0 ? "입력성공" : "입력실패";
    }

    @PutMapping(value = "/empupdate.do",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "text/plain;charset=utf-8")
    public String update(@RequestBody EmpDTO emp) {
        int result = empService.updateService(emp);
        return result > 0 ? "수정성공" : "수정실패";
    }

    @DeleteMapping(value = "/empdelete.do/{empid}",
            produces = "text/plain;charset=utf-8")
    public String delete(@PathVariable int empid) {
        int result = empService.deleteService(empid);
        return result > 0 ? "삭제성공" : "삭제실패";
    }
}
