package com.schoolCard.service;

import com.schoolCard.entity.Major;

public interface MajorService {
    int insert(Major major);

    int delete(int id);

    int update(Major major);

    Major selete(int id);
}
