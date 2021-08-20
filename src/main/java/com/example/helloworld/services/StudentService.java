package com.example.helloworld.services;

import com.example.helloworld.dao.StudentDao;
import com.example.helloworld.entity.Student;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author: ZhangLiZhi
 * @Date: 2021/8/13
 */

@Service
public interface StudentService {

    /**
     *
     * @author zhanglizhi
     * @create 2021/8/13
     * @param id 用户ID
     * @return
     * 查找用户信息
     */

    Student findById(Integer id);

    Student findByIdXml(Integer id) throws IOException;

    void addStu(Student student);

    void deleteStu(Integer id);

    void updateStuName(String name, Integer id);

    Student findById2(Integer id);

    void addStu2(Student student);

    void deleteStu2(Integer id);

    void updateStuName2(Student student);
}
