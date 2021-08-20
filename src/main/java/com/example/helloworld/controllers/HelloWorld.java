package com.example.helloworld.controllers;

import com.example.helloworld.annotation.ResponseAnnotation;
import com.example.helloworld.dao.StudentJPA;
import com.example.helloworld.entity.Student;
import com.example.helloworld.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Author: ZhangLiZhi
 * @Date: 2021/8/12
 */

@RestController
@ResponseAnnotation
public class HelloWorld {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private StudentJPA studentJPA;

    @GetMapping("/")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/students/{id}")
    @Cacheable(value = "Student", key = "#id")
    public Student helloStudent(@PathVariable("id") Integer id) throws IOException {
        return studentService.findByIdXml(id);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody RequestStu requestStu) {
        mongoTemplate.save(requestStu);
        studentService.addStu(new Student(requestStu.getName(),requestStu.getNum()));
    }

    @PatchMapping("/students/{name}/{id}")
    public void pathStudent(@PathVariable("name") String name,
                            @PathVariable("id") Integer id) {
        redisTemplate.opsForValue().set(id, name);
        System.out.println(redisTemplate.opsForValue().get(id));
        studentService.updateStuName(name, id);
    }

    @DeleteMapping("/students/{id}")
    public void deleStu(@PathVariable("id") Integer id) {
        studentService.deleteStu(id);
    }

    @GetMapping("/students2/{id}")
    public Student helloStudent2(@PathVariable("id") Integer id){
        return studentService.findById2(id);
    }

    @PostMapping("/students2")
    public void addStudent2(@RequestBody RequestStu requestStu) {
        studentService.addStu2(new Student(requestStu.getName(),requestStu.getNum()));
    }

    @PatchMapping("/students2/{name}/{id}/{num}")
    public void pathStudent(@PathVariable("name") String name,
                            @PathVariable("id") Integer id,
                            @PathVariable("num") Integer num) {
        studentService.updateStuName2(new Student(id, name, num));
    }

    @DeleteMapping("/students2/{id}")
    public void deleStu2(@PathVariable("id") Integer id) {
        studentService.deleteStu2(id);
    }

    @GetMapping("/students3/{id}")
    public Student helloStudent3(@PathVariable("id") Integer id){
        return studentJPA.getById(id);
    }

    @PostMapping("/students3")
    public void addStudent3(@RequestBody RequestStu requestStu) {
        studentJPA.save(new Student(requestStu.getName(),requestStu.getNum()));
    }

    @PatchMapping("/students3/{name}/{id}/{num}")
    public void pathStudent3(@PathVariable("name") String name,
                            @PathVariable("id") Integer id,
                            @PathVariable("num") Integer num) {
        studentJPA.save(new Student(id, name, num));
    }

    @DeleteMapping("/students3/{id}")
    public void deleStu3(@PathVariable("id") Integer id) {
        studentJPA.deleteById(id);
    }
}
