package com.y.service.Impl;

import com.y.dao.adminDao;
import com.y.entity.admin;
import com.y.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    adminDao adminDao;

    public void setAdminDao(com.y.dao.adminDao adminDao) {
        this.adminDao = adminDao;
    }

    public admin adminLogin(String username, String password) {
        admin admin = adminDao.adminLogin(username, password);
        return admin;
    }
}
