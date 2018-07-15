package com.schoolCard.dao;

import com.schoolCard.entity.TeacherAccount;

import java.util.List;

public interface TeacherAccountMapper {
    int insert(TeacherAccount record);

    int insertSelective(TeacherAccount record);

    int updateByPrimaryKey(TeacherAccount record);

    int deleteByPrimaryKey(int jzxId);

    TeacherAccount select(int id);

    List<TeacherAccount> selectall();
}