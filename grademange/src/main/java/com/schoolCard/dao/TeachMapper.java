package com.schoolCard.dao;

import com.schoolCard.entity.Teach;

public interface TeachMapper {
    int insert(Teach record);

    int insertSelective(Teach record);
}