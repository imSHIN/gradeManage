package com.schoolCard.controller;

import com.schoolCard.entity.Classes;
import com.schoolCard.service.classesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classes")
public class classesController {
    @Autowired
    private classesService  classesService;

    // 增加一班级
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insertClasses(Classes classes) {
        return classesService.insertClasses(classes);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public int deleteClasses(int id) {
        return classesService.deleteClasses(id);
    }

    // 更新
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public int updateClasses(Classes classes) {
        return classesService.updateClasses(classes);
    }
}
