package com.schoolCard.serviceImpl;

import com.schoolCard.dao.TeacherMapper;
import com.schoolCard.entity.Teacher;
import com.schoolCard.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public int insert(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.updateByPrimaryKey(teacher);
    }

    @Override
    public int delete(int id) {
        return teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Teacher selete(int id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Teacher> selectAll(){
        return teacherMapper.selectAll();
    }

    @Override
    public List<HashMap<String,Object>> queryAllCourse(int id){
        return teacherMapper.queryAllCourse(id);
    }
}
