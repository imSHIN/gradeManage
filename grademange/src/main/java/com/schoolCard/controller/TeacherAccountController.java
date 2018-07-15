package com.schoolCard.controller;

import com.schoolCard.entity.Teacher;
import com.schoolCard.entity.TeacherAccount;
import com.schoolCard.service.TeacherAccountService;
import com.schoolCard.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacheraccount")
public class TeacherAccountController {
    @Autowired
    private TeacherAccountService teacherAccountService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insertNewTeacher(TeacherAccount teacher){
        return teacherAccountService.insert(teacher);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(int id){
        return teacherAccountService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int update(TeacherAccount teacher){
        return teacherAccountService.update(teacher);
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public TeacherAccount selete(int id){
        return teacherAccountService.selete(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int select(TeacherAccount teacherAccount) {
        TeacherAccount teacherAccount1 =  teacherAccountService.selete(teacherAccount.getJzxTeacherid());
        if (teacherAccount1.getJzxPassword().equals(teacherAccount.getJzxPassword())){
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/selectall", method = RequestMethod.POST)
    public List<TeacherAccount> selectall(){
        return teacherAccountService.selectall();
    }
}
