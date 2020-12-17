package com.hg.dao;

import com.hg.pojo.Student;

import java.util.List;

public interface StudentMapper {
    /**
     *查询所有的学生信息以及对应老师i的信息
     */
    public List<Student> getStudent();
    public List<Student> getStudent2();
}
