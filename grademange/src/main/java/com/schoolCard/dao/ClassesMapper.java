package com.schoolCard.dao;

import com.schoolCard.entity.Classes;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer jzxId);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer jzxId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}