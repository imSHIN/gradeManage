package com.schoolCard.controller;

import com.schoolCard.entity.Course;
import com.schoolCard.entity.Teacher;
import com.schoolCard.service.CourseSservice;
import com.schoolCard.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseSservice courseService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insertNewTeacher(Course teacher){
        return courseService.insertCourse(teacher);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(int id){
        return courseService.deleteCourse(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int update(Course teacher){
        return courseService.updateCourse(teacher);
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public Course selete(int id){
        return courseService.seleteCourse(id);
    }

    @RequestMapping(value = "/selectbyclass", method = RequestMethod.POST)
    public List<Course> selectByClass(int id){
        return courseService.selectByClass(id);
    }
}
