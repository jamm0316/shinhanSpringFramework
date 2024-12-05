package com.shinhan.myapp.model;

import com.shinhan.myapp.vo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//DAO: 업무로직 수행, DB에 CRUD
//Service: 업무로직 수행, DB CRUD와 무관한 로직
@Service  //@Component + Service 기능
public class MemberService {

    @Autowired
    MemberDAO memberDAO;

    public MemberDTO loginService(String member_id, String member_pass) {
        return memberDAO.login(member_id, member_pass);
    }
}
