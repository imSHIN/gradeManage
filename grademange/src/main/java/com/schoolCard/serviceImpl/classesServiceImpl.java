package com.schoolCard.serviceImpl;

import com.schoolCard.dao.ClassesMapper;
import com.schoolCard.entity.Classes;
import com.schoolCard.service.classesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class classesServiceImpl implements classesService {
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public int insertClasses(Classes classes) {
        return classesMapper.insert(classes);
    }

    @Override
    public int deleteClasses(int id) {
        return classesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateClasses(Classes classes) {
        return classesMapper.updateByPrimaryKeySelective(classes);
    }
}
