package com.schoolCard.dao;

import com.schoolCard.entity.Card;

import java.util.List;

public interface CardMapper {
    int deleteByPrimaryKey(String id);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);

    List<Card> queryAll();
}