package com.schoolCard.serviceImpl;

import com.schoolCard.dao.CourseMapper;
import com.schoolCard.entity.Course;
import com.schoolCard.service.CourseSservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseSservice{
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public int insertCourse(Course course) {
        return courseMapper.insert(course);
    }

    @Override
    public int deleteCourse(int id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public Course seleteCourse(int id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Course> selectByClass(int id){
        return courseMapper.selectByClass(id);
    }
}
