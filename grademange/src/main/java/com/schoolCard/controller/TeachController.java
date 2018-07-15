package com.schoolCard.controller;

import com.schoolCard.entity.Teach;
import com.schoolCard.entity.Teacher;
import com.schoolCard.service.TeachService;
import com.schoolCard.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teach")
public class TeachController {
    @Autowired
    private TeachService teachService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insertNewTeacher(Teach teacher){
        return teachService.insert(teacher);
    }

//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public int delete(int id){
//        return teachService.delete(id);
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public int update(Teach teacher){
//        return teachService.update(teacher);
//    }
//
//    @RequestMapping(value = "/select", method = RequestMethod.POST)
//    public Teach selete(int id){
//        return teachService.selete(id);
//    }
}
