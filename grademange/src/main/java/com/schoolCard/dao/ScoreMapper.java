package com.schoolCard.dao;

import com.schoolCard.entity.Score;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface ScoreMapper {
    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer jzxId);

    HashMap<String, Object> queryavg(Integer id);

    List<HashMap<String, Object>> scoreOrder(Integer courseid);

    List<HashMap<String, Object>> selectbyid(String id);


    List<HashMap<String, Object>> enterScore(@Param("teacherid") Integer teacherid, @Param("courseid") Integer courseid);
}