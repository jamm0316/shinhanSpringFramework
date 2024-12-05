package com.shinhan.myapp.model;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class AccountDAOMybatis {

    @Autowired
    SqlSession sqlSession;

    public int deposit() {
        return sqlSession.update("com.shinhan.account.update1", "112");
    }

    public int withdraw() {
        return sqlSession.update("com.shinhan.account.update2");
    }
}
