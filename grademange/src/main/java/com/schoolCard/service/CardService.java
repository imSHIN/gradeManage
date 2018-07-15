package com.schoolCard.service;

import com.schoolCard.entity.Card;

import java.util.List;

public interface CardService {

    // 添加新的卡
    int insertCard(Card card);

    // 删除一张卡
    int deleteCard(String studentId);

    // 更新卡的信息(如余额)
    int updateCardInfo(Card card);

    // 查询一条信息
    Card queryOne(String studentId);

    // 查询所有信息
    List<Card> queryAll();
}
