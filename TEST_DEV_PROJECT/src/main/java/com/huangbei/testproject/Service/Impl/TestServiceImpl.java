package com.huangbei.testproject.Service.Impl;

import com.huangbei.testproject.Dao.TestMapper;
import com.huangbei.testproject.Entity.Person;
import com.huangbei.testproject.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public List<Person> getCount() {
        List<Person> person = testMapper.getCount();
        return person;
    }
}
