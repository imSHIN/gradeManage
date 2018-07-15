package com.schoolCard.controller;

import com.schoolCard.entity.Major;
import com.schoolCard.entity.Teacher;
import com.schoolCard.service.MajorService;
import com.schoolCard.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insertNewTeacher(Major teacher){
        return majorService.insert(teacher);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(int id){
        return majorService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int update(Major teacher){
        return majorService.update(teacher);
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public Major selete(int id){
        return majorService.selete(id);
    }
}
