package com.schoolCard.controller;

import com.schoolCard.entity.Teacher;
import com.schoolCard.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insertNewTeacher(Teacher teacher){
        return teacherService.insert(teacher);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(int id){
        return teacherService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int update(Teacher teacher){
        return teacherService.update(teacher);
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public Teacher selete(int id){
        return teacherService.selete(id);
    }

    @RequestMapping(value = "/selectall", method = RequestMethod.POST)
    public List<Teacher> selectAll() {
        return teacherService.selectAll();
    }

    @RequestMapping(value = "/teachsourse", method = RequestMethod.POST)
    public List<HashMap<String,Object>> queryAllCourse(int id){
        return teacherService.queryAllCourse(id);
    }
}
