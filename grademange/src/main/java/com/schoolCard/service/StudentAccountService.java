package com.schoolCard.service;

import com.schoolCard.entity.StudentAccount;

import java.util.List;

public interface StudentAccountService {
    int insert(StudentAccount studentAccount);

    int update(StudentAccount studentAccount);

    int delete(String id);

    StudentAccount select(String id);

    List<StudentAccount> selectall();
}
