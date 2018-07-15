package com.schoolCard.dao;

import com.schoolCard.entity.Monitor;

import java.util.List;

public interface MonitorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Monitor record);

    int insertSelective(Monitor record);

    List<Monitor> selectByPrimaryKey(String studentid);

    int updateByPrimaryKeySelective(Monitor record);

    int updateByPrimaryKey(Monitor record);

    List<Monitor> queryAll();
}