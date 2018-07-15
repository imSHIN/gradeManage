package com.schoolCard.service;

import com.schoolCard.entity.Score;

import java.util.HashMap;
import java.util.List;

public interface ScoreService {
    int insert(Score score);

    int delete(int id);

    int update(Score score);

    Score selete(int id);

    HashMap<String, Object> queryavg(int id);

    List<HashMap<String, Object>> scoreOrder(int courseid);

    List<HashMap<String, Object>> enterScore(int teacherid, int courseid);

    List<HashMap<String, Object>> selectbyid(String id);
}
