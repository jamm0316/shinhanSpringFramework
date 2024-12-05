package com.shinhan.myapp.model;

import com.shinhan.myapp.vo.DeptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    //type이 같으면 자동으로 Injection (IoC, DI)
    @Autowired

    //같은 type이 여러개 있으면 오류
    //@Qualifier("deptMybatis"): 이름으로 Injection한다.
    @Qualifier("deptMybatis")
    DeptDAOInterface deptDao;

    // 1.모두조회
    public List<DeptDTO> selectAllService() {
        return deptDao.selectAll();
    }

    // 2.상세보기
    public DeptDTO selectByIdService(int deptid) {
        return deptDao.selectById(deptid);
    }

    // 3.입력
    public int insertService(DeptDTO dept) {

        return deptDao.insert(dept);
    }

    // 4.수정
    public int updateService(DeptDTO dept) {
        return deptDao.update(dept);
    }

    // 5.삭제
    public int deleteService(int deptid) {
        return deptDao.delete(deptid);
    }
}






