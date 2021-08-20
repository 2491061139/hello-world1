package com.example.helloworld.services.impl;

import com.example.helloworld.dao.StudentDao;
import com.example.helloworld.entity.Student;
import com.example.helloworld.services.StudentService;
import lombok.Data;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author: ZhangLiZhi
 * @Date: 2021/8/13
 */

@Data
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student findById(Integer id) {
        return studentDao.findById(id);
    }

    @Override
    public Student findByIdXml(Integer id) throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        return studentDao.findById(id);
    }

    @Override
    public void addStu(Student student) {
        studentDao.insertIntoStudent(student);
    }

    @Override
    public void deleteStu(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public void updateStuName(String name, Integer id) {
        studentDao.updateStudent(name, id);
    }

    @Override
    public Student findById2(Integer id) {
        return studentDao.getStu(id);
    }

    @Override
    public void addStu2(Student student) {
        studentDao.insert(student);
    }

    @Override
    public void deleteStu2(Integer id) {
        studentDao.deleteById2(id);
    }

    @Override
    public void updateStuName2(Student student) {
        studentDao.update(student);
    }


}
