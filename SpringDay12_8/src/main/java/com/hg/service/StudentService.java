package com.hg.service;

import com.hg.entity.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
    public void add(Student student);
}
