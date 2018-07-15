package com.schoolCard.controller;

import com.schoolCard.entity.StudentAccount;
import com.schoolCard.entity.Teacher;
import com.schoolCard.service.StudentAccountService;
import com.schoolCard.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/studentaccount")
public class StudentAccountController {
    @Autowired
    private StudentAccountService studentAccountService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insertNewTeacher(StudentAccount teacher){
        return studentAccountService.insert(teacher);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(String id){
        return studentAccountService.delete(id);
    }
//
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int update(StudentAccount teacher){
        return studentAccountService.update(teacher);
    }
//
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int selete(StudentAccount studentAccount){
        if (studentAccount == null || studentAccount.getJzxStudentid() == null) return 0;
        StudentAccount studentAccount1 = studentAccountService.select(studentAccount.getJzxStudentid());

        if (studentAccount1 != null && studentAccount1.getJzxPassword().equals(studentAccount.getJzxPassword())){
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/selectall", method = RequestMethod.POST)
    public List<StudentAccount> selectall(){
        return studentAccountService.selectall();
    }
}
