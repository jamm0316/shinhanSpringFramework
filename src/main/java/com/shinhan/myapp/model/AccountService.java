package com.shinhan.myapp.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED)  //default = REQUIRED
public class AccountService {

    @Autowired
    AccountDAOMybatis dao;

    public void transferService() {
        int ret1 = dao.deposit();
        int ret2 = dao.withdraw();
        log.debug("trasferService 결과: deposit=" + ret1 + "trasferService 결과: withdraw=" + ret2);
        log.info("trasferService 결과: deposit=" + ret1 + "trasferService 결과: withdraw=" + ret2);
        log.warn("trasferService 결과: deposit=" + ret1 + "trasferService 결과: withdraw=" + ret2);
        log.error("trasferService 결과: deposit=" + ret1 + "trasferService 결과: withdraw=" + ret2);
    }
}
