package com.yetta.pilipili.service.test;

import com.yetta.pilipili.dao.test.TestDao;
import com.yetta.pilipili.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl {
    @Autowired
    TestDao testDao;

    Test selectById(int id){
        Test test=testDao.selectById(id);
        System.out.println(test);
        return test;
    }
}
