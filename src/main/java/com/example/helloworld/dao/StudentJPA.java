package com.example.helloworld.dao;

import com.example.helloworld.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @className: StudentJPA
 * @author: ZhangLiZhi
 * @date: 2021-08-20
 **/

@Repository
public interface StudentJPA extends JpaRepository<Student, Integer> {
}
