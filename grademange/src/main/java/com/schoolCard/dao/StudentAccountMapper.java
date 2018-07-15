package com.schoolCard.dao;

import com.schoolCard.entity.StudentAccount;

import java.util.List;

public interface StudentAccountMapper {
    int insert(StudentAccount record);

    int insertSelective(StudentAccount record);

    int updateByPrimaryKey(StudentAccount record);
    
    int seleteByPrimaryKey(String id);

    int deleteByPrimaryKey(String id);

    StudentAccount select(String id);
    List<StudentAccount> selectall();
}