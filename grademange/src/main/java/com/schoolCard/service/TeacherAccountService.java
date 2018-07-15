package com.schoolCard.service;

import com.schoolCard.entity.TeacherAccount;

import java.util.List;

public interface TeacherAccountService {
    int insert(TeacherAccount teacherAccount);

    int delete(int id);

    TeacherAccount selete(int id);

    int update(TeacherAccount teacherAccount);

    List<TeacherAccount> selectall();
}
