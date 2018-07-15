package com.schoolCard.serviceImpl;

import com.schoolCard.dao.MajorMapper;
import com.schoolCard.entity.Major;
import com.schoolCard.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImpl implements MajorService{
    @Autowired
    private MajorMapper majorMapper;
    @Override
    public int insert(Major major) {
        return majorMapper.insert(major);
    }

    @Override
    public int delete(int id) {
        return majorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Major major) {
        return majorMapper.updateByPrimaryKeySelective(major);
    }

    @Override
    public Major selete(int id) {
        return majorMapper.selectByPrimaryKey(id);
    }
}
