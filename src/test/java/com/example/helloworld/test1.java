package com.example.helloworld;

import com.example.helloworld.controllers.HelloWorld;
import com.example.helloworld.dao.StudentDao;
import com.example.helloworld.entity.Student;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author: ZhangLiZhi
 * @Date: 2021/8/13
 */

public class test1 {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void test1() {
    }
}
