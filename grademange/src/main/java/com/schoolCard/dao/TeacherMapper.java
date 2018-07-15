package com.schoolCard.dao;

import com.schoolCard.entity.Teacher;

import java.util.HashMap;
import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer jzxId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer jzxId);

    List<Teacher> selectAll();

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<HashMap<String,Object>> queryAllCourse(int id);
}