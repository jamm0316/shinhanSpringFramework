package com.shinhan.myapp.model;

import com.shinhan.myapp.vo.DeptDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <bean id="deptDAO2" class="com.shinhan.myapp.model.DeptDAO"/>
 */

@Slf4j
@Repository("deptMybatis")  //DAO역할을 하는 @Componenet
public class DeptDAOMybatis implements DeptDAOInterface{

	//DB => DataSource => sqlSessionFactory => sqlSession
	@Autowired
	SqlSession sqlSession;

	String namespace = "com.shinhan.dept.";

	// 1.모두조회
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptList = sqlSession.selectList(namespace + "selectAll");
		log.info("dept조회 건수: " + deptList.size());
		return deptList;
	}

	// 2.상세보기
	public DeptDTO selectById(int deptid) {
		DeptDTO deptVO = sqlSession.selectOne(namespace + "selectById", deptid);
		log.info("deptVO: " + deptVO);
		return deptVO;
	}

	// 3.입력
	public int insert(DeptDTO dept) {
		int result = sqlSession.insert(namespace + "insert", dept);
		log.info("입력건수: " + result);
		return result;
	}

	// 4.수정
	public int update(DeptDTO dept) {
		int result = sqlSession.insert(namespace + "update", dept);
		log.info("수정건수: " + result);
		return result;	}

	// 5.삭제
	public int delete(int deptid) {
		int result = sqlSession.insert(namespace + "delete", deptid);
		log.info("삭제건수: " + result);
		return result;
	}
}
