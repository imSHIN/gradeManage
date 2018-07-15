package com.schoolCard.controller;

import com.schoolCard.entity.Score;
import com.schoolCard.entity.Teacher;
import com.schoolCard.service.ScoreService;
import com.schoolCard.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insertNewTeacher(Score teacher){
        return scoreService.insert(teacher);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(int id){
        return scoreService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int update(Score teacher){
        return scoreService.update(teacher);
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public Score selete(int id){
        return scoreService.selete(id);
    }

    @RequestMapping(value = "/queryavg", method = RequestMethod.POST)
    public HashMap<String,Object> queryAllCourse(int id) {
        return scoreService.queryavg(id);
    }

    @RequestMapping(value = "/scoreorder", method = RequestMethod.POST)
    public List<HashMap<String, Object>> scoreOrder(int courseid){
        return scoreService.scoreOrder(courseid);
    }

    @RequestMapping(value = "/enterscore/{teacherid}/{courseid}", method = RequestMethod.POST)
    public List<HashMap<String, Object>> enterScore(@PathVariable int teacherid,@PathVariable int courseid){
        System.out.println("daying");
//        if(teacherid == null || courseid == null) return null;
        System.out.println(teacherid + courseid);
        return scoreService.enterScore(teacherid, courseid);
    }

    @RequestMapping(value = "selectbyid", method = RequestMethod.POST)
    public List<HashMap<String, Object>> selectbyid(String id){
        return scoreService.selectbyid(id);
    }
}
