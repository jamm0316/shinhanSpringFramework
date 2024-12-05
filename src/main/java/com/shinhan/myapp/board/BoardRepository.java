package com.shinhan.myapp.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class BoardRepository {

    @Autowired
    SqlSession sqlSession;
    String nameSpace = "com.shinhan.board.";

    public List<BoardDTO> findAll() {
        return sqlSession.selectList(nameSpace + "selectAll");
    }

    public BoardDTO findOne(long boardId) {
        return sqlSession.selectOne(nameSpace + "selectById", boardId);
    }

    public int insert(BoardDTO boardVO) {
        return sqlSession.insert(nameSpace + "insert", boardVO);
    }

    public int update(BoardDTO boardVO) {
        return sqlSession.update(nameSpace + "update", boardVO);
    }

    public int delete(long boardId) {
        return sqlSession.delete(nameSpace + "delete", boardId);
    }
}
