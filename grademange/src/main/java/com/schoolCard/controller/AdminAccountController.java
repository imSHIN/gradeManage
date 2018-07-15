package com.schoolCard.controller;

import com.schoolCard.entity.AdminAccount;
import com.schoolCard.service.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/adminaccount")
public class AdminAccountController {
    @Autowired
    private AdminAccountService adminAccountService;

    // 增加一名新用户
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insertAdminAccount(AdminAccount adminAccount) {
        System.out.println(adminAccount.getJzxPassword());
        System.out.println("1111111");
        return adminAccountService.insertAdminAccount(adminAccount);
    }

    // 删除一名管理员账号
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int deleteAdminAccount(int id) {
        return adminAccountService.deleteAdminAccount(id);
    }

    // 更新一名管理员账号
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int updateAdminAccount(AdminAccount adminAccount) {
        return adminAccountService.updateAdminAccount(adminAccount);
    }

    // 登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int loginIn(AdminAccount adminAccount) {
        if(adminAccount == null) return 0;
        int id = adminAccount.getJzxId();
        AdminAccount cpadminAccount = adminAccountService.seleteAdminAccount(id);
        String password = cpadminAccount.getJzxPassword();
        if (adminAccount.getJzxPassword().equals(password)) {
            return 1;
        } else {
            return 0;
        }
    }
}
