package com.huangbei.testproject.Dao;

import com.huangbei.testproject.Entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("testMapper")
public interface TestMapper {
    List<Person> getCount();
}
