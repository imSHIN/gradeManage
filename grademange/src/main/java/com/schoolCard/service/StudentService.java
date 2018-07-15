package com.schoolCard.service;

import com.schoolCard.entity.Student;

import java.util.List;

public interface StudentService {
    int insert(Student student);

    int update(Student student);

    int delete(String id);

    Student selete(String id);

    List<Student> selectAll();

    List<Student> adressSelect(String jzxAdress);
}
