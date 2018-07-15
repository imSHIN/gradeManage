package com.schoolCard.serviceImpl;

import com.schoolCard.dao.CardMapper;
import com.schoolCard.entity.Card;
import com.schoolCard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService{
    @Autowired
    private CardMapper cardDao;

    @Override
    public int insertCard(Card card) {
        int t = cardDao.insertSelective(card);
        return t;
    }

    @Override
    public int deleteCard(String studentId) {
        int t = cardDao.deleteByPrimaryKey(studentId);
        return t;
    }

    @Override
    public int updateCardInfo(Card card) {
        int t = cardDao.updateByPrimaryKeySelective(card);
        return t;
    }

    @Override
    public List<Card> queryAll() {
        List<Card> cardList = cardDao.queryAll();
        return cardList;
    }

    @Override
    public Card queryOne(String studentId) {
        Card card = cardDao.selectByPrimaryKey(studentId);
        return card;
    }
}

