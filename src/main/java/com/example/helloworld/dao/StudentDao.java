package com.example.helloworld.dao;

import com.example.helloworld.entity.Student;
import org.apache.ibatis.annotations.*;

/**
 * @Author: ZhangLiZhi
 * @Date: 2021/8/13
 */

@Mapper
public interface StudentDao {

    /**
     * TODO
     * 
     * @author zhanglizhi
     * @date 2021/8/13
     * @param id 用户ID
     */
    Student findById(@Param("id") Integer id);

    /**
     * TODO
     * 
     * @author zhanglizhi
     * @date 2021/8/17
     * @param student 学生实体类
     * @return
     */
    Integer insertIntoStudent(Student student);

    /**
     * TODO
     *
     * @author zhanglizhi
     * @date 2021/8/13
     * @param
     * @return
     */
    void updateStudent(String name, Integer id);

    /**
     * TODO
     *
     * @author zhanglizhi
     * @date 2021/8/13
     * @param
     * @return
     */
    void deleteById(Integer id);

    /**
     * TODO
     *
     * @author zhanglizhi
     * @date 2021/8/13
     * @param
     * @return
     */
    @Insert("insert into student_info (stu_name,stu_num) values (#{name},#{num})")
    void insert(Student student);

    /**
     * TODO
     *
     * @author zhanglizhi
     * @date 2021/8/13
     * @param
     * @return
     */
    @Delete("delete from student_info where stu_id = #{id}")
    void deleteById2(Integer id);

    /**
     * TODO
     *
     * @author zhanglizhi
     * @date 2021/8/13
     * @param
     * @return
     */
    @Update("update student_info set stu_name = #{name}, stu_num = #{num} where stu_id = #{id}")
    void update(Student student);

    /**
     * TODO
     *
     * @author zhanglizhi
     * @date 2021/8/13
     * @param
     * @return
     */
    @Select("select stu_id,stu_name,stu_num from student_info where stu_id = #{id}")
    @Results(value = {
            @Result(column = "stu_id", property = "id"),
            @Result(column = "stu_num", property = "num"),
            @Result(column = "stu_name", property = "name")
    })
    Student getStu(@Param("id") Integer id);

}
