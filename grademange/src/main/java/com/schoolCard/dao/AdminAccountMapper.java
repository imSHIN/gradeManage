package com.schoolCard.dao;

import com.schoolCard.entity.AdminAccount;

public interface AdminAccountMapper {
    int deleteByPrimaryKey(Integer jzxId);

    int insert(AdminAccount record);

    int insertSelective(AdminAccount record);

    AdminAccount selectByPrimaryKey(Integer jzxId);

    int updateByPrimaryKeySelective(AdminAccount record);

    int updateByPrimaryKey(AdminAccount record);
}