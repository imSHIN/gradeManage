package com.schoolCard.serviceImpl;

import com.schoolCard.dao.StudentMapper;
import com.schoolCard.entity.Student;
import com.schoolCard.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public int insert(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int update(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int delete(String id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Student selete(String id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> selectAll(){
        return studentMapper.selectAll();
    }

    @Override
    public List<Student> adressSelect(String jzxAdress){
        return studentMapper.adressSelect(jzxAdress);
    }
}
