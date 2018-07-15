package com.schoolCard.serviceImpl;

import com.schoolCard.dao.AdminAccountMapper;
import com.schoolCard.entity.AdminAccount;
import com.schoolCard.service.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAccountServiceImpl implements AdminAccountService{
    @Autowired
    private AdminAccountMapper adminAccountMapper;

    @Override
    public int insertAdminAccount(AdminAccount adminAccount) {
        int t = adminAccountMapper.insert(adminAccount);
        return t;
    }

    @Override
    public int deleteAdminAccount(int Id) {
        return adminAccountMapper.deleteByPrimaryKey(Id);
    }

    @Override
    public int updateAdminAccount(AdminAccount adminAccount) {
        return adminAccountMapper.updateByPrimaryKey(adminAccount);
    }

    @Override
    public AdminAccount seleteAdminAccount(int Id) {
        return adminAccountMapper.selectByPrimaryKey(Id);
    }
}
