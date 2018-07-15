package com.schoolCard.service;

import com.schoolCard.entity.Teacher;

import java.util.HashMap;
import java.util.List;

public interface TeacherService {
    int insert(Teacher teacher);

    int update(Teacher teacher);

    int delete(int id);

    Teacher selete(int id);

    List<Teacher> selectAll();

    List<HashMap<String,Object>> queryAllCourse(int id);
}
