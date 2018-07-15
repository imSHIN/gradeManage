package com.schoolCard.serviceImpl;

import com.schoolCard.dao.StudentAccountMapper;
import com.schoolCard.entity.StudentAccount;
import com.schoolCard.service.StudentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAccountServiceImpl implements StudentAccountService{
    @Autowired
    private StudentAccountMapper studentAccountMapper;
    @Override
    public int insert(StudentAccount studentAccount) {
        return studentAccountMapper.insert(studentAccount);
    }

    @Override
    public int update(StudentAccount studentAccount){
        return studentAccountMapper.updateByPrimaryKey(studentAccount);
    }

    @Override
    public int delete(String id){
        return studentAccountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public StudentAccount select(String id){
        return studentAccountMapper.select(id);
    }

    @Override
    public List<StudentAccount> selectall(){
        return studentAccountMapper.selectall();
    }
}
