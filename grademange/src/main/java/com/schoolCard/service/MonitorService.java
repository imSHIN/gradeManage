package com.schoolCard.service;

import com.schoolCard.entity.Monitor;

import java.util.List;

public interface MonitorService {
    // 添加一条新的监控
    int insertMonitor(Monitor monitor);

    // 删除一条监控数据
    int deleteMonitor(int id);

    //查询一条数据
    List<Monitor> queryOne(String studentid);

    // 查询所有数据
    List<Monitor> queryAll();
}
