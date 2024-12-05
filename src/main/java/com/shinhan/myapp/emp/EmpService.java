package com.shinhan.myapp.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//사용자요청-->Controller--->Service--->DAO--->DB
//DB관련없는 업무로직은 Service에서 수행 
@Service
public class EmpService {

    /**
     * @Autowired: type이 같으면 injection, 이름이 같으면 injection
     * @Qualifier: 이르므으로 injection
     */

    @Autowired
    @Qualifier("empMybatis")
    EmpDAOInterface empDAO;

    //
    public List<EmpDTO> selectByDept(int dept_id) {
        return empDAO.selectByDept(dept_id);
    }

    public List<EmpDTO> selectByJob(String job_id) {
        return empDAO.selectByJob(job_id);
    }

    public List<EmpDTO> selectBySalary(double salary) {
        return empDAO.selectBySalary(salary);
    }

    public List<EmpDTO> selectByCondition(Map<String, Object> map) {
        return empDAO.selectByCondition(map);
    }

    //
    public List<EmpDTO> selectAllService() {
        return empDAO.selectAll();
    }

    public List<JobDTO> selectAllJobsService() {
        return empDAO.selectAllJobs();
    }

    public EmpDTO selectByIdService(int empid) {
        // TODO Auto-generated method stub
        return empDAO.selectById(empid);
    }

    // 입력서비스
    public int insertEmp(EmpDTO emp) {
        return empDAO.insert(emp);

    }

    // 수정서비스
    public int updateService(EmpDTO emp) {
        return empDAO.update(emp);
    }

    // 삭제서비스
    public int deleteService(int empid) {
        return empDAO.delete(empid);
    }

    public List<EmpJoinDTO> selectByJobJoin(String jobid) {
        return empDAO.selectJobJoin(jobid);
    }

    public Map<String, Object> selectByJobJoin2(String jobid) {
        return empDAO.selectJoin2(jobid);
    }

    public List<Map<String, Object>> selectByJobJoin3(String jobid) {
        return empDAO.selectJoin3(jobid);
    }
}







