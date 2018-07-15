package com.schoolCard.dao;

import com.schoolCard.entity.Major;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer jzxId);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer jzxId);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}