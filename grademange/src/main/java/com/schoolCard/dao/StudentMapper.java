package com.schoolCard.dao;

import com.schoolCard.entity.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String jzxId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String jzxId);

    List<Student> selectAll();

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> adressSelect(String jzxAdress);
}