package com.schoolCard.service;

import com.schoolCard.entity.Course;

import java.util.List;

public interface CourseSservice {
    int insertCourse(Course course);

    int deleteCourse(int id);

    int updateCourse(Course course);

    Course seleteCourse(int id);

    List<Course> selectByClass(int id);
}
