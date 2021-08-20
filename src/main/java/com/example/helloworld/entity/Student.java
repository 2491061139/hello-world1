package com.example.helloworld.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: ZhangLiZhi
 * @Date: 2021/8/13
 */

@Data
@Component
@Entity
@Table(name = "student_info")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "stu_id")
    private Integer id;
    @Column(name = "stu_name")
    private String name;
    @Column(name = "stu_num")
    private Integer num;

    public Student(){}

    public Student(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public Student(Integer id, String name, Integer num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }
}
