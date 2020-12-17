package com.hg.dao;

import com.hg.entity.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentDao {
    public void add(Student student);
}
