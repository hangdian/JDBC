package com.hg.service;

import com.hg.dao.StudentDao;
import com.hg.dao.StudentImpl;
import com.hg.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentDao studentDao=new StudentImpl();



    public void add(Student student) {

        System.out.println("service is loading....");
        studentDao.add(student);
    }
}
