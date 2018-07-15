package com.schoolCard.service;

import com.schoolCard.entity.Classes;

public interface classesService {
    // 添加一个班级
    int insertClasses(Classes classes);

    // 删除一个班级
    int deleteClasses(int id);

    // 修改信息
    int updateClasses(Classes classes);
}
