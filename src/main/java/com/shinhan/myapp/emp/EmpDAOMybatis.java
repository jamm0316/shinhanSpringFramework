package com.shinhan.myapp.emp;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

//Data Source(DB연결) => SqlSessionFactory(DB와 Mapper를 Session이 알고있음) => SqlSession(생성)
//  ==> DAO ==> Service ==> Controller
@Slf4j
@Repository("empMybatis")
public class EmpDAOMybatis implements EmpDAOInterface {

    @Autowired
    SqlSession sqlSession;

    String namespace = "com.shinhan.emp.";

    //return값 = sqlSession.selectOne("namespace와 mapper의 id, 파라메터")
    //return값 = sqlSession.selectList("")
    //return값 = sqlSession.selectMap("")

    public List<JobDTO> selectAllJobs() {
        List<JobDTO> emplist = sqlSession.selectList(namespace + "selectAllJob");
        log.info("mybatis >> job 찾기:" + emplist.size());
        return emplist;
    }


    public List<Map<String, Object>> selectJoin3(String jobid) {
        List<Map<String, Object>> emplist = sqlSession.selectList(namespace + "selectJoin2", jobid);
        log.info("mybatis >> map 조건 찾기:" + emplist.size());
        return emplist;
    }
    public Map<String, Object> selectJoin2(String jobid) {
        return null;
    }

    public List<EmpJoinDTO> selectJobJoin(String jobid) {
        List<EmpJoinDTO> emplist = sqlSession.selectList(namespace + "selectJoin", jobid);
        log.info("mybatis >> emp 조건 찾기:" + emplist.size());
        return emplist;
    }


    //1.특정부서의 직원조회      where department_id = ?
    public List<EmpDTO> selectByDept(int dept_id) {
        List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByDept", dept_id);
        log.info("mybatis >> emp 부서 찾기:" + emplist.size());
        return emplist;
    }


    //2.특정job_id인 직원조회   where job_id = ?
    public List<EmpDTO> selectByJob(String job_id) {
        List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByJobid", job_id);
        log.info("mybatis >> emp 직책 찾기:" + emplist.size());
        return emplist;
    }

    //3.급여가 ?이상인 직원조회   where salary >= ?
    public List<EmpDTO> selectBySalary(double salary) {
        List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectBySalary", salary);
        log.info("mybatis >> emp 급여 찾기:" + emplist.size());
        return emplist;
    }

    //4.부서, 직책, 급여, 입사일 조건으로 조회
    //     where department_id = ? and job_id = ? and salary >= ? and  hire_date >= ?
    public List<EmpDTO> selectByCondition(Map<String, Object> map) {
        List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByCondition2", map);
        log.info("mybatis >> emp 조건 찾기:" + emplist.size());
        return emplist;
    }

    public List<EmpDTO> selectAll() {
        List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectAll");
        log.info("mybatis >> emp 전부 찾기:" + emplist.size());
        return emplist;
    }

    public EmpDTO selectById(int empid) {
        // 특정 직원을 조회하기
        EmpDTO emp = sqlSession.selectOne(namespace + "selectById", empid);
        log.info("mybatis >> emp id로 찾기:" + emp.toString());
        return emp;
    }

    // DB에 입력
    public int insert(EmpDTO emp) {
        int result = sqlSession.insert(namespace + "insert", emp);
        log.info("mybatis >> 입력된 건수:" + result);
        return result;
    }

    // 수정
    public int update(EmpDTO emp) {
        int result = sqlSession.update(namespace + "update", emp);
        log.info("mybatis >> 수정된 건수:" + result);
        return result;
    }

    // 삭제
    public int delete(int empid) {
        int result = sqlSession.delete(namespace + "delete", empid);
        log.info("mybatis >> 삭제된 건수:" + result);
        return result;
    }
}
