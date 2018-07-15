package com.schoolCard.service;

import com.schoolCard.entity.AdminAccount;

public interface AdminAccountService {
    // 添加新的学生用户
    public int insertAdminAccount(AdminAccount adminAccount);

    // 删除一位学生用户
    public int deleteAdminAccount(int Id);

    // 修改信息
    public int updateAdminAccount(AdminAccount adminAccount);

    // 查询一名用户的信息
    AdminAccount seleteAdminAccount(int Id);
}
