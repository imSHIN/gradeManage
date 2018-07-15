package com.schoolCard.dao;

import com.schoolCard.entity.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer jzxId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer jzxId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> selectByClass(int id);
}