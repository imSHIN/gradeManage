package com.schoolCard.serviceImpl;

import com.schoolCard.dao.TeacherAccountMapper;
import com.schoolCard.entity.TeacherAccount;
import com.schoolCard.service.TeacherAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherAccountServiceImpl implements TeacherAccountService{
    @Autowired
    private TeacherAccountMapper teacherAccountMapper;
    @Override
    public int insert(TeacherAccount teacherAccount) {
        return teacherAccountMapper.insert(teacherAccount);
    }

    @Override
    public int delete(int id) {
        return teacherAccountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TeacherAccount selete(int id) {
        return teacherAccountMapper.select(id);
    }

    @Override
    public int update(TeacherAccount teacherAccount) {
        return teacherAccountMapper.updateByPrimaryKey(teacherAccount);
    }

    @Override
    public List<TeacherAccount> selectall(){
        return teacherAccountMapper.selectall();
    }
}
