package com.shinhan.myapp.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;


    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findOne(long boardId) {
        return boardRepository.findOne(boardId);
    }

    public int insert(BoardDTO boardVO) {
        return boardRepository.insert(boardVO);
    }

    public int update(BoardDTO boardVO) {
        return boardRepository.update(boardVO);
    }

    public int delete(long boardId) {
        return boardRepository.delete(boardId);
    }
}
