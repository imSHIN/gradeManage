package com.schoolCard.controller;

import com.schoolCard.entity.Card;
import com.schoolCard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    /*
    * 增加新卡
    * @param card
    * */
    @RequestMapping(value = "/insertCard", method = RequestMethod.POST)
    public Card insertCard(Card card) {
        if (card != null || card.getStudentid() != null || card.getId() != null) {
            cardService.insertCard(card);
        } else {
            return null;
        }
        return card;
    }

    /*
    * 删除一张卡
    * @param studentId 学号
    * */
    @RequestMapping(value = "/deleteCard", method = RequestMethod.POST)
    public int deleteCard(String studentId) {
        int t = cardService.deleteCard(studentId);
        return t;
    }

    /*
    * 更新
    * */
    @RequestMapping(value = "/updateCard", method = RequestMethod.POST)
    public Card updateCard(Card card) {
        if (card != null && card.getStudentid() != null) {
            String studentid = card.getStudentid();
            Card card1 = cardService.queryOne(studentid);
            // 卡的状态是1表示没有被挂失可以使用 否则返回null
            if (card1.getCardstatus() == 1) {
                cardService.updateCardInfo(card);
                return card;
            }
        } else {
            return null;
        }
        return null;
    }

    /*
    * 查询一张卡的信息
    * @param studentId 学号
    * */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Card queryOne(String studentId) {
        Card card = cardService.queryOne(studentId);
        return card;
    }

    /*
    * 查询所有卡的信息
    * */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public List<Card> queryAll() {
        List<Card> cardList = cardService.queryAll();
        return cardList;
    }
}
