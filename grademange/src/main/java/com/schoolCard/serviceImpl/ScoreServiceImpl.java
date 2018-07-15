package com.schoolCard.serviceImpl;

import com.schoolCard.dao.ScoreMapper;
import com.schoolCard.entity.Score;
import com.schoolCard.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public int insert(Score score) {
        return scoreMapper.insert(score);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(Score score) {
        return 0;
    }

    @Override
    public Score selete(int id) {
        return null;
    }

    @Override
    public HashMap<String, Object>  queryavg(int id) {
        return scoreMapper.queryavg(id);
    }

    @Override
    public List<HashMap<String, Object>> scoreOrder(int courseid){
        return scoreMapper.scoreOrder(courseid);
    }

    @Override
    public List<HashMap<String, Object>> enterScore(int teacherid, int courseid){
        return scoreMapper.enterScore(teacherid, courseid);
    }

    @Override
    public  List<HashMap<String, Object>> selectbyid(String id) {
        return scoreMapper.selectbyid(id);
    }
}
