package com.y.controller;

import com.y.entity.admin;
import com.y.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/login")
    public @ResponseBody
    String userLogin(String data, HttpServletRequest request) throws IOException {
//        System.out.println("进来了登录");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("拿到了前台的用户名："+username);
        System.out.println("拿到了前台的密码："+password);

        admin admin = adminService.adminLogin(username, password);
        if (admin!=null && !(admin.equals(""))){
            request.getSession().setAttribute("admin",admin);
            return "success";
        }
        return "wrong";
    }

    @RequestMapping("/exit")
    public String userExit(HttpServletRequest request) throws IOException {
        System.out.println("进来了退出");
        request.getSession().removeAttribute("admin");
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/login.jsp";
        return viewname;
    }

    @RequestMapping("/index")
    public String userIndex(HttpServletRequest request) throws IOException {
        System.out.println("进来了登录");
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/login.jsp";
        return viewname;
    }
}
