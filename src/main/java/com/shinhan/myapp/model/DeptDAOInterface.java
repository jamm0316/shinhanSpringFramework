package com.shinhan.myapp.model;

import com.shinhan.myapp.vo.DeptDTO;

import java.util.List;

public interface DeptDAOInterface {
    // 1.모두조회
    public List<DeptDTO> selectAll();

    // 2.상세보기
    public DeptDTO selectById(int deptid);

    // 3.입력
    public int insert(DeptDTO dept);

    // 4.수정
    public int update(DeptDTO dept);

    // 5.삭제
    public int delete(int deptid);
}
