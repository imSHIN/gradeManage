package com.schoolCard.serviceImpl;

import com.schoolCard.dao.TeachMapper;
import com.schoolCard.entity.Teach;
import com.schoolCard.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachServiceImpl implements TeachService{
    @Autowired
    private TeachMapper teachMapper;
    @Override
    public int insert(Teach teach) {
        return teachMapper.insert(teach);
    }
}
