package com.schoolCard.serviceImpl;

import com.schoolCard.dao.MonitorMapper;
import com.schoolCard.entity.Monitor;
import com.schoolCard.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService{
    @Autowired
    MonitorMapper monitorDao;

    @Override
    public int insertMonitor(Monitor monitor) {
        return monitorDao.insertSelective(monitor);
    }

    @Override
    public int deleteMonitor(int id) {
        return monitorDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Monitor> queryAll() {
        return monitorDao.queryAll();
    }

    @Override
    public List<Monitor> queryOne(String studentid) {
        return monitorDao.selectByPrimaryKey(studentid);
    }
}
