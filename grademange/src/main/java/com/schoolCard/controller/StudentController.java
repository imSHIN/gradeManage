package com.schoolCard.controller;

import com.schoolCard.entity.Student;
import com.schoolCard.entity.Teacher;
import com.schoolCard.service.StudentService;
import com.schoolCard.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insertNewTeacher(Student teacher){
        return studentService.insert(teacher);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(String id){
        return studentService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int update(Student teacher){
        return studentService.update(teacher);
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public Student selete(String id){
        return studentService.selete(id);
    }

    @RequestMapping(value = "/selectall", method = RequestMethod.POST)
    public List<Student> seleteAll(){
        return studentService.selectAll();
    }

    @RequestMapping(value = "/adressselect", method = RequestMethod.POST)
    public List<Student> adressSelete(String adress){
        return studentService.adressSelect(adress);
    }
}
